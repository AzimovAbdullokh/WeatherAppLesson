package com.example.weatherapp.domain.models.current_weather

data class WeatherCloudDomainModel(
    val all: Int,
) {
    companion object {
        val unknown = WeatherCloudDomainModel(
            all = 0,
        )
    }
}