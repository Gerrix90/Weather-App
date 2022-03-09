package com.weatherapp.service.repository.remote.entity_mapper.hourly_weather

import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.model.hourly_weather.Hourly
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyWeatherEntity
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.EntityMapper
import javax.inject.Inject

class HourlyWeatherMapper
@Inject constructor(
    private var currentMapper: CurrentMapper,
    private var hourlyMapper: HourlyMapper
) : EntityMapper<HourlyWeatherEntity, HourlyWeather>{
    override fun mapFromEntity(entity: HourlyWeatherEntity): HourlyWeather {
        return HourlyWeather(
            lat = entity.lat,
            lon = entity.lon,
            timezone = entity.timezone,
            timezoneOffset = entity.timezone_offset,
            current = currentMapper.mapFromEntity(entity.current),
            hourly = hourlyMapper.mapFromEntityList(entity.hourly)
        )
    }

    override fun mapToEntity(domainModel: HourlyWeather): HourlyWeatherEntity {
        TODO("Not yet implemented")
    }
}