package com.weatherapp.service.repository.remote.entity.hourly_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HourlyWeatherEntity(
    @SerializedName("lat")
    @Expose
    var lat: Double,
    @SerializedName("lon")
    @Expose
    var lon: Double,
    @SerializedName("timezone")
    @Expose
    var timezone: String,
    @SerializedName("timezone_offset")
    @Expose
    var timezone_offset: Int,
    @SerializedName("current")
    @Expose
    var current: CurrentEntity,
    @SerializedName("hourly")
    @Expose
    var hourly: List<HourlyEntity>
)
