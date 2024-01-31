package com.example.weatherapp.domain.use_cases

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.models.weather_for_fifteen.ListWeather
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursListsModelDomain
import com.example.weatherapp.domain.repository.WeatherRepository

class DefaultGetWeatherForFifteenDays(
    private val repository: WeatherRepository,
    private val getCurrentLocationManager: GetCurrentLocationManager
) : GetWeatherForFifteenDays {

    override suspend fun invoke(): ResultStatus<List<ListWeather>> {
        val currentLocation = getCurrentLocationManager.getCurrentLocation()
        return if (currentLocation != null) repository.getWeatherForFifteenDays(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        ) else return repository.getWeatherForFifteenDays(0.0, 0.0)
    }
}
