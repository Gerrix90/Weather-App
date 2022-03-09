package com.weatherapp.service.repository.remote.entity_mapper.current_weather

import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.repository.remote.entity.current_weather.WeatherMainEntity
import javax.inject.Inject

class WeatherMainMapper
@Inject constructor(
    private val coordMapper: CoordMapper,
    private val weatherDescMapper : WeatherDescMapper,
    private val mainMapper : MainMapper,
    private val windMapper : WindMapper,
    private val cloudsMapper: CloudsMapper,
    private val sysMapper: SysMapper,
) : EntityMapper<WeatherMainEntity, WeatherMain> {
    override fun mapFromEntity(entity: WeatherMainEntity): WeatherMain {
        return WeatherMain(
            coord = coordMapper.mapFromEntity(entity.coord),
            weather = weatherDescMapper.mapFromEntityList(entity.weather),
            base = entity.base,
            main = mainMapper.mapFromEntity(entity.main),
            visibility = entity.visibility,
            wind = windMapper.mapFromEntity(entity.wind),
            clouds = cloudsMapper.mapFromEntity(entity.clouds),
            dt = entity.dt,
            sys = sysMapper.mapFromEntity(entity.sys),
            timezone = entity.timezone,
            id = entity.id,
            name = entity.name,
            cod = entity.cod

        )
    }

    override fun mapToEntity(domainModel: WeatherMain): WeatherMainEntity {
        TODO("Not yet implemented")
    }
}