package com.weatherapp.service.repository.remote.entity.current_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherMainEntity(
    @SerializedName("coord")
    @Expose
    var coord: CoordEntity,
    @SerializedName("weather")
    @Expose
    var weather: List<WeatherDescEntity>,
    @SerializedName("base")
    @Expose
    var base: String,
    @SerializedName("main")
    @Expose
    var main: MainEntity,
    @SerializedName("visibility")
    @Expose
    var visibility: Int,
    @SerializedName("wind")
    @Expose
    var wind: WindEntity,
    @SerializedName("clouds")
    @Expose
    var clouds: CloudsEntity,
    @SerializedName("dt")
    @Expose
    var dt: Int,
    @SerializedName("sys")
    @Expose
    var sys: SysEntity,
    @SerializedName("timezone")
    @Expose
    var timezone: Int,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("cod")
    @Expose
    var cod: Int
)


























