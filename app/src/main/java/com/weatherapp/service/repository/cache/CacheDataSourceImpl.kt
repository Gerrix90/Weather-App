package com.weatherapp.service.repository.cache

import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.cache.mappers.HourlyWeatherCacheMapper

class CacheDataSourceImpl(
    private val weatherDaoService: WeatherDaoService,
    private val hourlyWeatherCacheMapper: HourlyWeatherCacheMapper
) : CacheDataSource {
    override suspend fun insert(hourlyWeather: HourlyWeather) {
        weatherDaoService.insert(hourlyWeatherCacheMapper.mapToEntity(hourlyWeather))
    }

    override suspend fun getHourlyWeather(): HourlyWeather {
        return hourlyWeatherCacheMapper.mapFromEntity(weatherDaoService.get())
    }

    override suspend fun deleteAll() {
        weatherDaoService.deleteAll()
    }
}