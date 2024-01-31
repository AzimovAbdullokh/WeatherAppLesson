package com.example.weatherapp.domain.models.weather_for_fifteen_days

import java.io.Serializable

data class WeatherWindInfoModelInDayDomain(
    val weatherSpeed: Double,
    val weatherDag: Int,
    val weatherGust: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModelInDayDomain(
            weatherDag = 0,
            weatherSpeed = 0.0,
            weatherGust = 0
        )
    }
}