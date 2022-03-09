package com.weatherapp.service.repository.remote

import com.weatherapp.service.repository.remote.entity.current_weather.WeatherMainEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRepository {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat : Double,
        @Query("lon") lon : Double,
        @Query("appid") appId: String
    ) : WeatherMainEntity

    @GET("/data/2.5/onecall")
    suspend fun getHourlyWeather(
        @Query("lat") lat : Double,
        @Query("lon") lon : Double,
        @Query("exclude") exclude : String,
        @Query("appid") appId: String
    ): HourlyWeatherEntity
}