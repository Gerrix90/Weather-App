package com.weatherapp.service.repository

import android.content.Context
import com.weatherapp.service.Location
import kotlinx.coroutines.flow.Flow


interface LocationRepository {

    fun getLocation(context: Context) : Flow<Location>
}