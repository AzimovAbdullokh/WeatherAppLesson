package com.example.weatherapp.domain.models.current_weather

data class WeatherWindDomainModel(
    val windSpeed: Double,
    val windDeg: Int,
) {
    companion object {
        val unknown = WeatherWindDomainModel(
            windSpeed = 1.0,
            windDeg = 10,
        )
    }
}
