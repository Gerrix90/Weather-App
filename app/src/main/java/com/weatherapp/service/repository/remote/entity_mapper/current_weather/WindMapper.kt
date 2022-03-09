package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.Wind
import com.weatherapp.service.repository.remote.entity.current_weather.WindEntity
import javax.inject.Inject

class WindMapper
@Inject constructor() : EntityMapper<WindEntity, Wind> {
    override fun mapFromEntity(entity: WindEntity): Wind {
        return Wind(
            speed = entity.speed,
            deg = entity.deg,
            gust = entity.gust
        )
    }

    override fun mapToEntity(domainModel: Wind): WindEntity {
        TODO("Not yet implemented")
    }
}