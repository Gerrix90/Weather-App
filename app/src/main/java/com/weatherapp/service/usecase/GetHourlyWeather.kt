package com.weatherapp.service.usecase

import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.model.hourly_weather.HourlyWeather
import com.weatherapp.service.repository.DataState
import com.weatherapp.service.repository.cache.CacheDataSource
import com.weatherapp.service.repository.remote.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHourlyWeather(
    private val networkDataSource: NetworkDataSource,
    private val cacheDataSource: CacheDataSource

) {
    operator fun invoke(lat : Double, lon : Double) : Flow<DataState<HourlyWeather>> = flow {

        emit(DataState.Loading)
        val networkResponse = networkDataSource.getHourlyWeather(lat, lon)
        cacheDataSource.deleteAll()
        cacheDataSource.insert(networkResponse)

        emit(DataState.Success(cacheDataSource.getHourlyWeather()))
    }

}