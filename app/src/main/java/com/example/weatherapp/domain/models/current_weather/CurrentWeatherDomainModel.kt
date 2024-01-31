package com.example.weatherapp.domain.models.current_weather

data class CurrentWeatherDomainModel(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) {
    val isClear = weatherMain == "Clear"
    val isCloudy = weatherMain == "Clouds"
    val isMist = weatherMain == "Mist" || weatherMain == "Smoke"

    companion object {
        val unknown = CurrentWeatherDomainModel(
            weatherId = 1,
            weatherMain = "Rain",
            weatherDescription = "smoke"
        )
    }
}