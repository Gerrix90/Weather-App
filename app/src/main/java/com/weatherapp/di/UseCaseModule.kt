package com.weatherapp.di

import com.weatherapp.service.repository.LocationRepository
import com.weatherapp.service.repository.LocationRepositoryImpl
import com.weatherapp.service.usecase.GetLocation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideLocationRepository(): LocationRepository {
        return LocationRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideGetLocation(locationRepository: LocationRepository): GetLocation {
        return GetLocation(locationRepository)
    }
}