package com.weatherapp.service.repository.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.model.hourly_weather.Hourly

@Entity(tableName = "hourlyWeather")
class HourlyWeatherCacheEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "lat")
    var lat: Double,

    @ColumnInfo(name = "lon")
    var lon: Double,

    @ColumnInfo(name = "timezone")
    var timezone: String,

    @ColumnInfo(name = "timezoneOffset")
    var timezoneOffset: Int,

    @ColumnInfo(name = "current")
    var current: Current,

    @ColumnInfo(name = "hourly")
    var hourly: List<Hourly>
)