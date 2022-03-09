package com.weatherapp.service.repository.remote

import com.weatherapp.service.repository.remote.entity.current_weather.WeatherMainEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyWeatherEntity

class WeatherServiceImpl(
    private val weatherRepository: WeatherRepository
) : WeatherService {
    override suspend fun getWeather(lat : Double, lon : Double): WeatherMainEntity {
        return weatherRepository.getWeather(lat, lon,"2055e78d5c1183786c167beaab53b676" )
    }

    override suspend fun getHourlyWeather(
        lat: Double,
        lon: Double
    ): HourlyWeatherEntity {
        return weatherRepository.getHourlyWeather(lat, lon,"daily,minutely","2055e78d5c1183786c167beaab53b676" )
    }
}