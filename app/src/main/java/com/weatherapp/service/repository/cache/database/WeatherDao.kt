package com.weatherapp.service.repository.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherCacheEntity: HourlyWeatherCacheEntity)

    @Query("SELECT * FROM hourlyWeather")
    suspend fun get() : HourlyWeatherCacheEntity

    @Query("DELETE FROM hourlyWeather")
    suspend fun deleteAll()
}



























