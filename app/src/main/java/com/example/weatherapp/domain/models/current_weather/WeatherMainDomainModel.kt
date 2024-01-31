package com.example.weatherapp.domain.models.current_weather

data class WeatherMainDomainModel(
    val weatherTemperature: Double,
    val howWeatherFeels: Double,
    val weatherMinTemperature: Double,
    val weatherMaxTemperature: Double,
    val weatherPressure: Int,
    val weatherHumidity: Int,
) {
    companion object {
        val unkown = WeatherMainDomainModel(
            weatherTemperature = 280.42,
            howWeatherFeels = 279.16,
            weatherMinTemperature = 280.42,
            weatherMaxTemperature = 280.42,
            weatherPressure = 1021,
            weatherHumidity = 53,
        )
    }
}
