package com.weatherapp.service.repository.remote

import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.model.hourly_weather.HourlyWeather

interface NetworkDataSource {

    suspend fun getWeather(lat : Double, lon : Double) : WeatherMain
    suspend fun getHourlyWeather(lat : Double, lon : Double) : HourlyWeather
}