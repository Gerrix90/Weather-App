package com.weatherapp.service.repository.remote

import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.WeatherMainMapper
import com.weatherapp.service.repository.remote.entity_mapper.hourly_weather.HourlyWeatherMapper

class NetworkDataSourceImpl(
    private val weatherMapper : WeatherMainMapper,
    private val weatherService: WeatherService,
    private val hourlyWeatherMapper: HourlyWeatherMapper
) : NetworkDataSource {
    override suspend fun getWeather(lat : Double, lon : Double): WeatherMain {
        return weatherMapper.mapFromEntity(weatherService.getWeather(lat, lon))
    }
    override suspend fun getHourlyWeather(lat : Double, lon : Double): HourlyWeather {
        return hourlyWeatherMapper.mapFromEntity(weatherService.getHourlyWeather(lat, lon))
    }

}