package com.example.weatherapp.domain.use_cases

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.domain.repository.WeatherRepository

class DefaultGetCurrentWeatherUseCase(
    private val repository: WeatherRepository,
    private val getCurrentLocationManager: GetCurrentLocationManager
) : GetCurrentWeatherUseCase {

    override suspend fun invoke(): ResultStatus<WeatherDataDomainModel> {
        val currentLocation = getCurrentLocationManager.getCurrentLocation()
        return if (currentLocation != null) repository.getCurrentWeatherData(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        ) else return repository.getCurrentWeatherData(0.0, 0.0)
    }
}