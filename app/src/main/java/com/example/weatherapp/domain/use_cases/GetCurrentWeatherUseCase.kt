package com.example.weatherapp.domain.use_cases

import com.example.weatherapp.domain.models.WeatherDataDomainModel

interface GetCurrentWeatherUseCase {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
    ): WeatherDataDomainModel
}