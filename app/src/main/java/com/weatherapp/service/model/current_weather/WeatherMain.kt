package com.weatherapp.service.model.current_weather

data class WeatherMain(
    var coord: Coord,
    var weather: List<WeatherDesc>,
    var base: String,
    var main: Main,
    var visibility: Int,
    var wind: Wind,
    var clouds: Clouds,
    var dt: Int,
    var sys: Sys,
    var timezone: Int,
    var id: Int,
    var name: String,
    var cod: Int
)


























