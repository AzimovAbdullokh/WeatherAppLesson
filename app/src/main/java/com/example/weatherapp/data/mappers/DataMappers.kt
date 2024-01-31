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

fun WeatherDataDomainModel.toCache() = WeatherDataModel(
    weatherCoordinate = weatherCoordinate.toCache(),
    weather = currentWeather.map { it.toDomain() },
    weatherBase = weatherBase,
    weatherMain = weatherMain.toDomain(),
    visibility = weatherVisibility,
    weatherWindInfo = weatherWind.toDomain(),
    weatherClouds = weatherCloud.toDomain(),
    cityName = cityName,
    countryModel = this.countryModel.toDomain()
)

fun WeatherCoordinateDomainModel.toCache() = WeatherCoordinateModel(
    latitude = latitude,
    longitude = longitude
)

fun WeatherSysDataModel.toDomain() = WeatherSysDomainModel(
    country = this.country
)

fun CurrentWeatherDomainModel.toDomain() = WeatherCloudModel(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription
)

fun WeatherMainDomainModel.toDomain() = WeatherMainModel(
    weatherTemperature = weatherTemperature,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity,
    weatherMinTemp = weatherMinTemperature,
    weatherMaxTemp = weatherMaxTemperature,
    feelsLike = howWeatherFeels,
)

fun WeatherWindDomainModel.toDomain() = WeatherWindInfoModel(
    windSpeed = windSpeed,
    windDeg = windDeg
)

fun WeatherCloudDomainModel.toDomain() = WeatherCloudsModel(
    all = all
)

fun WeatherSysDomainModel.toDomain() = WeatherSysDataModel(
    country = country
)