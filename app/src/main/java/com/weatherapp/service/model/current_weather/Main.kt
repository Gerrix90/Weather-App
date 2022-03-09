package com.weatherapp.service.model.current_weather

data class Main(
    var temp : Double,
    var feelsLike : Double,
    var tempMin : Double,
    var tempMax : Double,
    var pressure : Int,
    var humidity : Int
)