package com.weatherapp.service.repository.remote.entity_mapper.hourly_weather

import com.weatherapp.service.model.current_weather.WeatherDesc
import com.weatherapp.service.model.hourly_weather.Hourly
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherDescEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.HourlyEntity
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.EntityMapper
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.WeatherDescMapper
import javax.inject.Inject

class HourlyMapper
@Inject constructor(
    private var weatherDescMapper: WeatherDescMapper

) : EntityMapper<HourlyEntity, Hourly>{
    override fun mapFromEntity(entity: HourlyEntity): Hourly {

        return Hourly(
            dt = entity.dt,
            temp = entity.temp,
            feelsLike = entity.feels_like,
            pressure = entity.pressure,
            humidity = entity.humidity,
            dewPoint = entity.dew_point,
            uvi = entity.uvi,
            clouds = entity.clouds,
            visibility = entity.visibility,
            windSpeed = entity.wind_speed,
            windDeg = entity.wind_deg,
            windGust = entity.wind_gust,
            weather = weatherDescMapper.mapFromEntityList(entity.weather),
            pop = entity.pop
        )
    }

    fun mapFromEntityList(entities: List<HourlyEntity>): List<Hourly>{
        return entities.map { mapFromEntity(it) }
    }

    override fun mapToEntity(domainModel: Hourly): HourlyEntity {
        TODO("Not yet implemented")
    }
}