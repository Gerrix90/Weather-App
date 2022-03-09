package com.weatherapp.service.repository.remote.entity.current_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WindEntity(
    @SerializedName("speed")
    @Expose
    var speed : Double,
    @SerializedName("deg")
    @Expose
    var deg : Int,
    @SerializedName("gust")
    @Expose
    var gust : Double
)
