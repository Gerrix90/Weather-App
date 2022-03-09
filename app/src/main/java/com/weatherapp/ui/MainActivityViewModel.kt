package com.weatherapp.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.weatherapp.service.usecase.GetLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.weatherapp.service.model.Location
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

//    init {
//        setEventState(EventState.GetWeather)
//    }

    private val _flowLocation = MutableStateFlow<Location>(Location(0.0, 0.0))
    val flowLocation = _flowLocation.asStateFlow()

    fun setEventState(eventState: EventState) {

        when (eventState) {
            is EventState.GetLocation -> {
                viewModelScope.launch {
                    getLocation(eventState.context).onEach { location ->
                        _flowLocation.value = location
                        setEventState(EventState.GetWeather)
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
                                Log.d("ddd", "setEventState: ${datastate.data.main}")
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
                                Log.d("ddd", "setEventState: ${datastate.data.current}")
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
}