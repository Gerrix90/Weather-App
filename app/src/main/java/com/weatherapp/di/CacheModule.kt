package com.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.cache.CacheDataSource
import com.weatherapp.service.repository.cache.CacheDataSourceImpl
import com.weatherapp.service.repository.cache.WeatherDaoService
import com.weatherapp.service.repository.cache.WeatherDaoServiceImpl
import com.weatherapp.service.repository.cache.database.WeatherDao
import com.weatherapp.service.repository.cache.database.WeatherDatabase
import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity
import com.weatherapp.service.repository.cache.mappers.HourlyWeatherCacheMapper
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideHourlyWeatherCacheMapper() : EntityMapper<HourlyWeatherCacheEntity, HourlyWeather>{
        return HourlyWeatherCacheMapper()
    }

    @Singleton
    @Provides
    fun provideWeatherDb(@ApplicationContext context: Context): WeatherDatabase{

        return Room
            .databaseBuilder(
                context,
                WeatherDatabase::class.java,
                WeatherDatabase.DATABASE_NAME
            ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDatabase: WeatherDatabase) : WeatherDao{
        return weatherDatabase.weatherDao()
    }

    @Singleton
    @Provides
    fun provideWeatherDaoService(weatherDao: WeatherDao) : WeatherDaoService {
        return WeatherDaoServiceImpl(weatherDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource (
        weatherDaoService: WeatherDaoService,
        hourlyWeatherCacheMapper: HourlyWeatherCacheMapper
    ) : CacheDataSource{
        return CacheDataSourceImpl(
        weatherDaoService,
        hourlyWeatherCacheMapper)
    }
}
























