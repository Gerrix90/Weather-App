package com.weatherapp.ui

import android.content.Context
import android.service.autofill.Dataset
import android.util.Log
import androidx.lifecycle.ViewModel
import com.weatherapp.service.usecase.GetLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.weatherapp.service.model.Location
import com.weatherapp.service.model.current_weather.WeatherMain
import com.weatherapp.service.model.hourly_weather.Hourly
import com.weatherapp.service.repository.DataState
import com.weatherapp.service.usecase.GetHourlyWeather
import com.weatherapp.service.usecase.GetWeather
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel
@Inject constructor(
    private val getLocation: GetLocation,
    private val getWeather: GetWeather,
    private val getHourlyWeather: GetHourlyWeather
) : ViewModel() {

    private val _flowLocation = MutableStateFlow<Location>(Location(0.0, 0.0))
    val flowLocation = _flowLocation.asStateFlow()

    private val _flowHourlyWeatherList = MutableStateFlow<AnswerState>(AnswerState.Nothing)
    val flowHourlyWeatherList = _flowHourlyWeatherList.asStateFlow()


    fun setEventState(eventState: EventState) {

        when (eventState) {
            is EventState.GetLocation -> {
                viewModelScope.launch {
                    getLocation(eventState.context).onEach { location ->
                        _flowLocation.value = location
//                        setEventState(EventState.GetWeather)
                        setEventState(EventState.GetHourlyWeather)
                    }.launchIn(viewModelScope)
                }
            }

            is EventState.GetWeather -> {
                viewModelScope.launch {
                    getWeather(
                        flowLocation.value.lat,
                        flowLocation.value.long
                    ).onEach { datastate ->
                        when (datastate) {
                            is DataState.Success -> {


                            }
                        }

                    }.launchIn(viewModelScope)

                }
            }

            is EventState.GetHourlyWeather -> {
                viewModelScope.launch {
                    getHourlyWeather(
                        flowLocation.value.lat,
                        flowLocation.value.long
                    ).onEach { datastate ->
                        when (datastate) {
                            is DataState.Success -> {
                                _flowHourlyWeatherList.value =
                                    AnswerState.Success(datastate.data.hourly)
                            }
                        }

                    }.launchIn(viewModelScope)

                }
            }
        }

    }

    sealed class EventState {
        object GetWeather : EventState()
        object GetHourlyWeather : EventState()
        data class GetLocation(val context: Context) : EventState()
    }

    sealed class AnswerState {
        object Nothing : AnswerState()
        object Error : AnswerState()
        data class Success(val hourlyList: List<Hourly>) : AnswerState()

    }


}