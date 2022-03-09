package com.weatherapp.service.repository.remote

import com.weatherapp.service.repository.remote.entity.current_weather.WeatherMainEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyWeatherEntity

interface WeatherService {

    suspend fun getWeather(lat : Double, lon : Double) : WeatherMainEntity
    suspend fun getHourlyWeather(lat : Double, lon : Double) : HourlyWeatherEntity
}