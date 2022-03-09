package com.weatherapp.service.model.hourly_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HourlyWeather(
    var lat: Double,
    var lon: Double,
    var timezone: String,
    var timezoneOffset: Int,
    var current: Current,
    var hourly: List<Hourly>
)
