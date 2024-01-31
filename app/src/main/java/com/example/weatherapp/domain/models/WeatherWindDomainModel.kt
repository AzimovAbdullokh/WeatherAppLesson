package com.example.weatherapp.domain.models

data class WeatherWindDomainModel(
    val windSpeed: Int,
    val windDeg: Int,
) {
    companion object {
        val unknown = WeatherWindDomainModel(
            windSpeed = -1,
            windDeg = -1,
        )
    }
}
