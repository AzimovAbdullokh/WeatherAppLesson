package com.example.weatherapp.domain.models

data class WeatherMainDomainModel(
    val  weatherTemperature: Double,
    val howWeatherFeels: Double,
    val weatherMinTemperature: Double,
    val weatherMaxTemperature: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
)
