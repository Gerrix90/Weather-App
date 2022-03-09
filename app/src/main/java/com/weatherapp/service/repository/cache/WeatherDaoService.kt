package com.weatherapp.service.repository.cache

import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity

interface WeatherDaoService {

    suspend fun insert(weatherCacheEntity: HourlyWeatherCacheEntity)
    suspend fun get() : HourlyWeatherCacheEntity
    suspend fun deleteAll()
}