package com.weatherapp.service.model.current_weather

data class Sys(
    var type : Int,
    var id : Int,
    var country : String,
    var sunrise : Int,
    var sunset : Int
)
