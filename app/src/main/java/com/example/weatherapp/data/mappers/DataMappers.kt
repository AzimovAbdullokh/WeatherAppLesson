package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.current_weather.WeatherCloudModel
import com.example.weatherapp.data.models.current_weather.WeatherCloudsModel
import com.example.weatherapp.data.models.current_weather.WeatherCoordinateModel
import com.example.weatherapp.data.models.current_weather.WeatherDataModel
import com.example.weatherapp.data.models.current_weather.WeatherMainModel
import com.example.weatherapp.data.models.current_weather.WeatherSysDataModel
import com.example.weatherapp.data.models.current_weather.WeatherWindInfoModel
import com.example.weatherapp.domain.models.current_weather.CurrentWeatherDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherCoordinateDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherMainDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherSysDomainModel
import com.example.weatherapp.domain.models.current_weather.WeatherWindDomainModel

fun WeatherCloudModel.toDomainModel() = CurrentWeatherDomainModel(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription
)

fun WeatherMainModel.toDomainModel() = WeatherMainDomainModel(
    weatherTemperature = weatherTemperature,
    howWeatherFeels = feelsLike,
    weatherMinTemperature = weatherMinTemp,
    weatherMaxTemperature = weatherMaxTemp,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity,
)

fun WeatherCoordinateModel.toDomainModel() = WeatherCoordinateDomainModel(
    latitude = latitude,
    longitude = longitude,
)

fun WeatherWindInfoModel.toDomainModel() = WeatherWindDomainModel(
    windSpeed = windSpeed,
    windDeg = windDeg
)

fun WeatherCloudsModel.toDomainModel() = WeatherCloudDomainModel(
    all = this.all,
)

fun WeatherDataModel.toDomainModel() = WeatherDataDomainModel(
    weatherCoordinate = weatherCoordinate.toDomainModel(),
    currentWeather = weather.map { it.toDomainModel() },
    weatherBase = weatherBase,
    weatherMain = weatherMain.toDomainModel(),
    weatherVisibility = visibility,
    weatherWind = weatherWindInfo.toDomainModel(),
    weatherCloud = weatherClouds.toDomainModel(),
    cityName = cityName,
    countryModel = this.countryModel.toDomain()
)

fun WeatherSysDataModel.toDomain() = WeatherSysDomainModel(
    country = this.country
)