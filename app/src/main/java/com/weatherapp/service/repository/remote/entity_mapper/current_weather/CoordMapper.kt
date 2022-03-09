package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.Coord
import com.weatherapp.service.repository.remote.entity.current_weather.CoordEntity
import javax.inject.Inject

class CoordMapper
@Inject constructor() : EntityMapper<CoordEntity, Coord> {
    override fun mapFromEntity(entity: CoordEntity): Coord {
        return Coord(
            entity.lon,
            entity.lat
        )
    }

    override fun mapToEntity(domainModel: Coord): CoordEntity {
        return CoordEntity(
            domainModel.lon,
            domainModel.lat
        )
    }
}