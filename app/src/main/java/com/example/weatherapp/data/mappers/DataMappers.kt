package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.WeatherCloudModel
import com.example.weatherapp.data.models.WeatherCloudsModel
import com.example.weatherapp.data.models.WeatherCoordinateModel
import com.example.weatherapp.data.models.WeatherDataModel
import com.example.weatherapp.data.models.WeatherMainModel
import com.example.weatherapp.data.models.WeatherWindInfoModel
import com.example.weatherapp.domain.models.CurrentWeatherDomainModel
import com.example.weatherapp.domain.models.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.WeatherCoordinateDomainModel
import com.example.weatherapp.domain.models.WeatherDataDomainModel
import com.example.weatherapp.domain.models.WeatherMainDomainModel
import com.example.weatherapp.domain.models.WeatherWindDomainModel

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
    currentWeather = weather.toDomainModel(),
    weatherBase = weatherBase,
    weatherMain = weatherMain.toDomainModel(),
    weatherVisibility = visibility,
    weatherWind = weatherWindInfo.toDomainModel(),
    weatherCloud = weatherClouds.toDomainModel(),
    cityName = cityName
)

fun CurrentWeatherDomainModel.toDataModelModel() = WeatherCloudModel(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription
)

fun WeatherMainDomainModel.toDataModelModel() = WeatherMainModel(
    weatherTemperature = weatherTemperature,
    feelsLike = howWeatherFeels,
    weatherMinTemp = weatherMinTemperature,
    weatherMaxTemp = weatherMaxTemperature,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity,
)


fun WeatherCloudDomainModel.toDataModelModel() = WeatherCloudsModel(
    all = all
)

fun WeatherCoordinateDomainModel.toDataModelModel() = WeatherCoordinateModel(
    latitude = latitude,
    longitude = longitude,
)

fun WeatherWindDomainModel.toDataModelModel() = WeatherWindInfoModel(
    windSpeed = windSpeed,
    windDeg = windDeg
)

fun WeatherDataDomainModel.toDataModelModel() = WeatherDataModel(
    weatherCoordinate = weatherCoordinate.toDataModelModel(),
    weather = currentWeather.toDataModelModel(),
    weatherBase = weatherBase,
    weatherMain = weatherMain.toDataModelModel(),
    visibility = weatherVisibility,
    weatherWindInfo = weatherWind.toDataModelModel(),
    weatherClouds = weatherCloud.toDataModelModel(),
    cityName = cityName
)