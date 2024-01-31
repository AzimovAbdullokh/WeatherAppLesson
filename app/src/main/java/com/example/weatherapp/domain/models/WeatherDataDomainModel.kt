package com.example.weatherapp.domain.models

data class WeatherDataDomainModel(
    val weatherCoordinate: WeatherCoordinateDomainModel,
    val currentWeather: CurrentWeatherDomainModel,
    val weatherBase: String,
    val weatherMain: WeatherMainDomainModel,
    val weatherVisibility: Int,
    val weatherWind: WeatherWindDomainModel,
    val weatherCloud: WeatherCloudDomainModel,
    val cityName: String,
)

