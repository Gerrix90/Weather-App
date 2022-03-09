package com.weatherapp.service.repository.remote.entity.current_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CloudsEntity(
    @SerializedName("all")
    @Expose
    var all : Int
)
