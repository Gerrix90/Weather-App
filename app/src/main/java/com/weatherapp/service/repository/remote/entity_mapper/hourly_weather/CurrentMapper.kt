package com.weatherapp.service.repository.remote.entity_mapper.hourly_weather

import com.weatherapp.service.model.hourly_weather.Current
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherDescEntity
import com.weatherapp.service.repository.remote.entity.hourly_weather.CurrentEntity
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.EntityMapper
import com.weatherapp.service.repository.remote.entity_mapper.current_weather.WeatherDescMapper
import javax.inject.Inject

class CurrentMapper
@Inject constructor(
    private var weatherDescMapper: WeatherDescMapper
) : EntityMapper<CurrentEntity, Current>{
    override fun mapFromEntity(entity: CurrentEntity): Current {

        return Current(
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

    override fun mapToEntity(domainModel: Current): CurrentEntity {
        TODO("Not yet implemented")
    }
}