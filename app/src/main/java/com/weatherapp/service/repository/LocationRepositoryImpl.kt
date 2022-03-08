package com.weatherapp.service.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weatherapp.service.Location
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class LocationRepositoryImpl : LocationRepository {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @ExperimentalCoroutinesApi
    @SuppressLint("MissingPermission")
    override fun getLocation(context: Context): Flow<Location> {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        var latitude = 0.0
        var longitude = 0.0

        return channelFlow {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: android.location.Location? ->
                    latitude = location?.latitude!!
                    longitude = location?.longitude
                    offer(Location(longitude, latitude))
                }
            awaitClose()
        }

    }


}