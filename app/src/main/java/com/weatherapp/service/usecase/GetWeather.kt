package com.weatherapp.service.usecase

import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.repository.DataState
import com.weatherapp.service.repository.remote.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWeather(
    private val networkDataSource: NetworkDataSource,
) {

    operator fun invoke(lat : Double, lon : Double) : Flow<DataState<WeatherMain>> = flow {

        emit(DataState.Loading)
        val networkResponse = networkDataSource.getWeather(lat, lon)

        emit(DataState.Success(networkResponse))
    }
}