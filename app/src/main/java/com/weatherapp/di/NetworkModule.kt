package com.weatherapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.weatherapp.service.model.current_weather.*
import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.model.hourly_weather.Hourly
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.remote.*
import com.weatherapp.service.repository.remote.entity.current_weather.*
import com.weatherapp.service.repository.remote.entity.hourly_weather.CurrentEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyWeatherEntity
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.*
import com.weatherapp.service.repository.remote.entity_mapper.hourly_weather.CurrentMapper
import com.weatherapp.service.repository.remote.entity_mapper.hourly_weather.HourlyMapper
import com.weatherapp.service.repository.remote.entity_mapper.hourly_weather.HourlyWeatherMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCloudsMapper(): EntityMapper<CloudsEntity, Clouds> {
        return CloudsMapper()
    }

    @Singleton
    @Provides
    fun provideCoordMapper(): EntityMapper<CoordEntity, Coord> {
        return CoordMapper()
    }

    @Singleton
    @Provides
    fun provideMainMapper(): EntityMapper<MainEntity, Main> {
        return MainMapper()
    }

    @Singleton
    @Provides
    fun provideSysMapper(): EntityMapper<SysEntity, Sys> {
        return SysMapper()
    }

    @Singleton
    @Provides
    fun provideWeatherDescMapper(): EntityMapper<WeatherDescEntity, WeatherDesc> {
        return WeatherDescMapper()
    }

    @Singleton
    @Provides
    fun provideCurrentMapper(weatherDescMapper: WeatherDescMapper): EntityMapper<CurrentEntity, Current> {
        return CurrentMapper(weatherDescMapper)
    }

    @Singleton
    @Provides
    fun provideHourlyMapper(weatherDescMapper: WeatherDescMapper): EntityMapper<HourlyEntity, Hourly> {
        return HourlyMapper(weatherDescMapper)
    }

    @Singleton
    @Provides
    fun provideHourlyWeatherMapper(
        currentMapper: CurrentMapper,
        hourlyMapper: HourlyMapper
    ) : EntityMapper<HourlyWeatherEntity, HourlyWeather>{
        return HourlyWeatherMapper(
            currentMapper,
            hourlyMapper
        )
    }

    @Singleton
    @Provides
    fun provideWeatherMainMapper(
        coordMapper: CoordMapper,
        weatherDescMapper: WeatherDescMapper,
        mainMapper: MainMapper,
        windMapper: WindMapper,
        cloudsMapper: CloudsMapper,
        sysMapper: SysMapper,
    ): EntityMapper<WeatherMainEntity, WeatherMain> {
        return WeatherMainMapper(
            coordMapper, weatherDescMapper, mainMapper, windMapper, cloudsMapper, sysMapper
        )
    }

    @Singleton
    @Provides
    fun provideWindMapper(): EntityMapper<WindEntity, Wind> {
        return WindMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .setLenient()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {

//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build()
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(retrofit: Retrofit.Builder): WeatherRepository {
        return retrofit
            .build()
            .create(WeatherRepository::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherService(weatherRepository: WeatherRepository): WeatherService {
        return WeatherServiceImpl(weatherRepository)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        weatherMapper: WeatherMainMapper,
        weatherService: WeatherService,
        hourlyWeatherMapper: HourlyWeatherMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(
            weatherMapper, weatherService,hourlyWeatherMapper
        )
    }
}