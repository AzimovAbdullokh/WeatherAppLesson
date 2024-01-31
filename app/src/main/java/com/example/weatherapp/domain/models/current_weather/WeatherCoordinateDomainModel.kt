package com.example.weatherapp.domain.models.current_weather

data class WeatherCoordinateDomainModel(
    val latitude: Double,
    val longitude: Double,
) {
    companion object {
        val unknown = WeatherCoordinateDomainModel(
            latitude = 0.0,
            longitude = 0.0,
        )
    }
}