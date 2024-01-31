package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.models.WeatherDataDomainModel

interface GetCurrentWeatherRepository {

    suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): WeatherDataDomainModel
}