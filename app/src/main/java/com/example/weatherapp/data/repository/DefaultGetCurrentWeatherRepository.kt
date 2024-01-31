package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mappers.toDomainModel
import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.domain.models.WeatherDataDomainModel
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import javax.inject.Inject

class DefaultGetCurrentWeatherRepository @Inject constructor(
    private val service: WeatherService
) : GetCurrentWeatherRepository {

    override suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): WeatherDataDomainModel {
        return (service.getCurrentWeather(
            latitude, longitude,
        ).body()?.toDomainModel() ?: WeatherDataDomainModel.unknown) as WeatherDataDomainModel
    }
}