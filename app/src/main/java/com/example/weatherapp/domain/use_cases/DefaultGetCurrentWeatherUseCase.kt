package com.example.weatherapp.domain.use_cases

import android.util.Log
import com.example.weatherapp.domain.models.WeatherDataDomainModel
import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository

class DefaultGetCurrentWeatherUseCase(
    private val repository: GetCurrentWeatherRepository
) : GetCurrentWeatherUseCase {

    override suspend fun invoke(
        latitude: Double,
        longitude: Double,
    ): WeatherDataDomainModel {
        Log.d("WEATHER_APP", "DefaultGetCurrentWeatherUseCase")
        return repository.getCurrentWeatherData(
            latitude = latitude,
            longitude = longitude,
        )
    }
}