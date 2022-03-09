package com.weatherapp.service.model.hourly_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.weatherapp.service.model.current_weather.WeatherDesc
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherDescEntity

data class Hourly(
    var dt: Int,
    var temp: Double,
    var feelsLike: Double,
    var pressure: Int,
    var humidity: Int,
    var dewPoint: Double,
    var uvi: Double,
    var clouds: Int,
    var visibility: Int,
    var windSpeed: Double,
    var windDeg: Int,
    var windGust: Double,
    var weather: List<WeatherDesc>,
    var pop: Double
)



















