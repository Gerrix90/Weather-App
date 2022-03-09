package com.weatherapp.service.repository.remote.entity.hourly_weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherDescEntity

data class HourlyEntity(
    @SerializedName("dt")
    @Expose
    var dt: Int,
    @SerializedName("temp")
    @Expose
    var temp: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_like: Double,
    @SerializedName("humidity")
    @Expose
    var pressure: Int,
    @SerializedName("id")
    @Expose
    var humidity: Int,
    @SerializedName("dew_point")
    @Expose
    var dew_point: Double,
    @SerializedName("uvi")
    @Expose
    var uvi: Double,
    @SerializedName("clouds")
    @Expose
    var clouds: Int,
    @SerializedName("visibility")
    @Expose
    var visibility: Int,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_deg")
    @Expose
    var wind_deg: Int,
    @SerializedName("wind_gust")
    @Expose
    var wind_gust: Double,
    @SerializedName("weather")
    @Expose
    var weather: List<WeatherDescEntity>,
    @SerializedName("pop")
    @Expose
    var pop: Double
)



















