package com.example.weatherapp.domain.models

data class WeatherCloudDomainModel(
    val all: Int,
) {
    companion object {
        val unknown = WeatherCloudDomainModel(
            all = -1,
        )
    }
}