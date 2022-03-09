package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.Main
import com.weatherapp.service.repository.remote.entity.current_weather.MainEntity
import javax.inject.Inject

class MainMapper
@Inject constructor() : EntityMapper<MainEntity, Main> {
    override fun mapFromEntity(entity: MainEntity): Main {
        return Main(
            temp = entity.temp,
            feelsLike = entity.feels_like,
            tempMin = entity.temp_min,
            tempMax = entity.temp_max,
            pressure = entity.pressure,
            humidity = entity.humidity
        )
    }

    override fun mapToEntity(domainModel: Main): MainEntity {

        return MainEntity(
            temp = domainModel.temp,
            feels_like = domainModel.feelsLike,
            temp_min = domainModel.tempMin,
            temp_max = domainModel.tempMax,
            pressure = domainModel.pressure,
            humidity = domainModel.humidity
        )
    }
}