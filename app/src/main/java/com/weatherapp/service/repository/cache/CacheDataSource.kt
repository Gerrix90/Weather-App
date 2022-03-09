package com.weatherapp.service.repository.cache

import com.weatherapp.service.model.hourly_weather.HourlyWeather

interface CacheDataSource {

    suspend fun insert(hourlyWeather: HourlyWeather)
    suspend fun getHourlyWeather() : HourlyWeather
    suspend fun deleteAll()
}