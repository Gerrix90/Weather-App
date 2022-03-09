package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.Clouds
import com.weatherapp.service.repository.remote.entity.current_weather.CloudsEntity
import javax.inject.Inject

class CloudsMapper
@Inject constructor() : EntityMapper<CloudsEntity, Clouds> {
    override fun mapFromEntity(entity: CloudsEntity): Clouds {

        return Clouds(
            entity.all
        )
    }

    override fun mapToEntity(domainModel: Clouds): CloudsEntity {
        return CloudsEntity(
            domainModel.all
        )
    }
}