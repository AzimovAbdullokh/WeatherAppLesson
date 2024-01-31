package com.example.weatherapp.domain.models.weather_for_fifteen_days

import java.io.Serializable

data class WeatherMainModelInDaysDomain(
    val weatherTemperature: Double,
    val feelsLike: Double,
    val weatherMinTemp: Double,
    val weatherMaxTemp: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
    val weatherSeaLevel: Int,
    val weatherLevel: Int,
) : Serializable {
    companion object {
        val unknown = WeatherMainModelInDaysDomain(
            weatherHumidity = 0,
            weatherMaxTemp = 0.0,
            weatherMinTemp = 0.0,
            weatherPressure = 0,
            weatherTemperature = 0.0,
            feelsLike = 0.0,
            weatherLevel = 0,
            weatherSeaLevel = 0
        )
    }
}