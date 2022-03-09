package com.weatherapp.service.repository.cache

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.weatherapp.service.model.current_weather.WeatherDesc
import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.model.hourly_weather.Hourly

class MyTypeConverters {

    @TypeConverter
    fun fromHourly(value: List<Hourly>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toHourly(value: String): List<Hourly> {
        return Gson().fromJson(value, Array<Hourly>::class.java).toList()
    }

    @TypeConverter
    fun fromWeatherDesc(value: List<WeatherDesc>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toWeatherDesc(value: String): List<WeatherDesc> {
        return Gson().fromJson(value, Array<WeatherDesc>::class.java).toList()
    }

    @TypeConverter
    fun fromCurrent(value: Current): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toCurrent(value: String): Current {
        return Gson().fromJson(value, Current::class.java)
    }
}