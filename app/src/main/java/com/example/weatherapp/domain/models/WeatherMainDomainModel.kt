package com.example.weatherapp.domain.models

data class WeatherMainDomainModel(
    val weatherTemperature: Double,
    val howWeatherFeels: Double,
    val weatherMinTemperature: Double,
    val weatherMaxTemperature: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
) {
    companion object {
        val unknown = WeatherMainDomainModel(
            weatherTemperature = 0.0,
            howWeatherFeels = 0.0,
            weatherMaxTemperature = 0.0,
            weatherMinTemperature = 0.0,
            weatherHumidity = -1,
            weatherPressure = -1,
        )
    }
}
