package com.weatherapp.service.repository.cache

import com.weatherapp.service.repository.cache.database.WeatherDao
import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity

class WeatherDaoServiceImpl constructor(
    private val weatherDao: WeatherDao
) : WeatherDaoService{
    override suspend fun insert(weatherCacheEntity: HourlyWeatherCacheEntity) {
        weatherDao.insert(weatherCacheEntity)
    }

    override suspend fun get(): HourlyWeatherCacheEntity {
        return weatherDao.get()
    }

    override suspend fun deleteAll() {
        weatherDao.deleteAll()

    }

}

























