package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.WeatherDesc
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherDescEntity
import javax.inject.Inject

class WeatherDescMapper
@Inject constructor() : EntityMapper<WeatherDescEntity, WeatherDesc> {
    override fun mapFromEntity(entity: WeatherDescEntity): WeatherDesc {
       return WeatherDesc(
           id = entity.id,
           main = entity.main,
           description = entity.description,
           icon = entity.icon
       )
    }

    fun mapFromEntityList(entities: List<WeatherDescEntity>): List<WeatherDesc>{
        return entities.map { mapFromEntity(it) }
    }

    override fun mapToEntity(domainModel: WeatherDesc): WeatherDescEntity {
        TODO("Not yet implemented")
    }
}