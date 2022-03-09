package com.weatherapp.service.repository.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.weatherapp.service.repository.cache.MyTypeConverters
import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity


@Database(entities = [HourlyWeatherCacheEntity::class], version = 1)
@TypeConverters(MyTypeConverters::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun  weatherDao() : WeatherDao

    companion object {
        val DATABASE_NAME : String = "weather_db"
    }
}






















