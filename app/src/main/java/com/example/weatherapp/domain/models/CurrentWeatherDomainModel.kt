package com.example.weatherapp.domain.models

data class CurrentWeatherDomainModel(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) {
    companion object {
        val unknown = CurrentWeatherDomainModel(
            weatherId = -1,
            weatherMain = String(),
            weatherDescription = String()
        )
    }
}