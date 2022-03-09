package com.weatherapp.service.usecase

import android.content.Context
import com.weatherapp.service.model.Location
import com.weatherapp.service.repository.LocationRepository
import kotlinx.coroutines.flow.Flow

class GetLocation(
    private val locationRepository : LocationRepository
) {

    operator fun invoke(context: Context) : Flow<Location>{
        return locationRepository.getLocation(context)
    }
}