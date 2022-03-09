package com.weatherapp.service.repository.cache.mappers

import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.model.hourly_weather.Hourly
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.cache.entity.HourlyWeatherCacheEntity
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.EntityMapper
import javax.inject.Inject

class HourlyWeatherCacheMapper
@Inject() constructor(
) : EntityMapper<HourlyWeatherCacheEntity, HourlyWeather>{
    override fun mapFromEntity(entity: HourlyWeatherCacheEntity): HourlyWeather {
        return HourlyWeather(
            lat = entity.lat,
            lon = entity.lon,
            timezone = entity.timezone,
            timezoneOffset = entity.timezoneOffset,
            current = entity.current,
            hourly = entity.hourly
        )
    }

    override fun mapToEntity(domainModel: HourlyWeather): HourlyWeatherCacheEntity {
       return HourlyWeatherCacheEntity(
           lat = domainModel.lat,
           lon = domainModel.lon,
           timezone = domainModel.timezone,
           timezoneOffset = domainModel.timezoneOffset,
           current = domainModel.current,
           hourly = domainModel.hourly
       )
    }
}