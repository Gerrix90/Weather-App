package com.weatherapp.service.repository.remote.entity.current_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoordEntity(

    @SerializedName("lon")
    @Expose
    var lon : Double,
    @SerializedName("lat")
    @Expose
    var lat : Double
)
