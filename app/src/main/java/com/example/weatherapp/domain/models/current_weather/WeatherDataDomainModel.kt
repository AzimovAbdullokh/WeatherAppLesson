package com.example.weatherapp.domain.models.current_weather


data class WeatherDataDomainModel(
    val weatherCoordinate: WeatherCoordinateDomainModel,
    val currentWeather: List<CurrentWeatherDomainModel>,
    val weatherBase: String,
    val weatherMain: WeatherMainDomainModel,
    val weatherVisibility: Int,
    val weatherWind: WeatherWindDomainModel,
    val weatherCloud: WeatherCloudDomainModel,
    val cityName: String,
    val countryModel: WeatherSysDomainModel
) {
    companion object {
        val preview = WeatherDataDomainModel(
            weatherCoordinate = WeatherCoordinateDomainModel.unknown,
            currentWeather = listOf(CurrentWeatherDomainModel.unknown),
            weatherBase = "stations",
            weatherMain = WeatherMainDomainModel.unkown,
            weatherVisibility = 53,
            weatherWind = WeatherWindDomainModel.unknown,
            weatherCloud = WeatherCloudDomainModel.unknown,
            cityName = "Osh",
            countryModel = WeatherSysDomainModel("KG")
        )
    }
}

