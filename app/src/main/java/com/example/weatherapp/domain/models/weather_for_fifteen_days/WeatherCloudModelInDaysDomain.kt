package com.example.weatherapp.domain.models.weather_for_fifteen_days

import java.io.Serializable

data class WeatherCloudModelInDaysDomain(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) : Serializable {
    companion object {
        val unknown = WeatherCloudModelInDaysDomain(
            weatherId = 0,
            weatherDescription = String(),
            weatherMain = String(),
        )
    }
}