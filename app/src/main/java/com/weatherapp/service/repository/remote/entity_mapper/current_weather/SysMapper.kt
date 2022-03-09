package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.Sys
import com.weatherapp.service.repository.remote.entity.current_weather.SysEntity
import javax.inject.Inject

class SysMapper
@Inject constructor() : EntityMapper<SysEntity, Sys> {
    override fun mapFromEntity(entity: SysEntity): Sys {
        return Sys(
            type = entity.type,
            id = entity.id,
            country = entity.country,
            sunrise = entity.sunrise,
            sunset = entity.sunset
        )
    }

    override fun mapToEntity(domainModel: Sys): SysEntity {
        TODO("Not yet implemented")
    }
}