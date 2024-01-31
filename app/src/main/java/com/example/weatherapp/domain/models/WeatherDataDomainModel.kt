package com.example.weatherapp.domain.models

data class WeatherDataDomainModel(
    val weatherCoordinate: WeatherCoordinateDomainModel,
    val currentWeather: CurrentWeatherDomainModel,
    val weatherBase: String,
    val weatherMain: WeatherMainDomainModel,
    val weatherVisibility: Int,
    val weatherWind: WeatherWindDomainModel,
    val weatherCloud: WeatherCloudDomainModel,
    val cityName: String,
) {
    companion object {
        val unknown = WeatherDataDomainModel(
            weatherCoordinate = WeatherCoordinateDomainModel.unknown,
            currentWeather = CurrentWeatherDomainModel.unknown,
            weatherBase = String(),
            weatherMain = WeatherMainDomainModel.unknown,
            weatherVisibility = -1,
            weatherWind = WeatherWindDomainModel.unknown,
            weatherCloud = WeatherCloudDomainModel.unknown,
            cityName = String()
        )
    }
}

