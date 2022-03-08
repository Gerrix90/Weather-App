package com.weatherapp.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.weatherapp.service.usecase.GetLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.weatherapp.service.Location
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel
@Inject constructor(
        private val getLocation: GetLocation
) : ViewModel() {



    private val _flowLocation = MutableStateFlow<Location>(Location(0.0, 0.0))
    val flowLocation = _flowLocation.asStateFlow()

    fun setEventState(eventState: EventState) {

        when(eventState){
            is EventState.GetLocation -> {
                viewModelScope.launch {
                    getLocation(eventState.context).onEach { location ->
                        Log.d("ddd", "setEventState: " + location.toString())
                        _flowLocation.value = location
                    }.launchIn(viewModelScope)
                }
            }
        }

    }

    sealed class EventState{
        data class GetLocation(val context: Context) : EventState()
    }
}