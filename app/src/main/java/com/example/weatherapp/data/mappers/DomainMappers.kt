package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.weather_for_fifteen_days.WeatherCloudModelInDays
import com.example.weatherapp.data.models.weather_for_fifteen_days.WeatherDayInHoursLists
import com.example.weatherapp.data.models.weather_for_fifteen_days.WeatherDayInHoursModel
import com.example.weatherapp.data.models.weather_for_fifteen_days.WeatherMainModelInDays
import com.example.weatherapp.data.models.weather_for_fifteen_days.WeatherWindInfoModelInDays
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherCloudModelInDaysDomain
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursListsModelDomain
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursModelDomain
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherMainModelInDaysDomain
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherWindInfoModelInDayDomain

fun WeatherDayInHoursModel.toDomainModel() = WeatherDayInHoursModelDomain(
    weatherList = weatherList.map { it.toDomainModel() },
)


fun WeatherCloudModelInDays.toDomainModel() = WeatherCloudModelInDaysDomain(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription
)

fun WeatherDayInHoursLists.toDomainModel() = WeatherDayInHoursListsModelDomain(
    weatherMain = weatherMain.toDomainModel(),
    weather = weather.toDomainModel(),
    weatherClouds = weatherClouds.toDomainModel(),
    weatherWind = weatherWind.toDomainModel(),
    weatherData = weatherData,
    visibility = visibility
)

fun WeatherMainModelInDays.toDomainModel() = WeatherMainModelInDaysDomain(
    weatherTemperature = weatherTemperature,
    feelsLike = feelsLike,
    weatherMinTemp = weatherMinTemp,
    weatherMaxTemp = weatherMaxTemp,
    weatherPressure = weatherPressure,
    weatherHumidity = weatherHumidity,
    weatherSeaLevel = weatherSeaLevel,
    weatherLevel = weatherLevel
)

fun WeatherWindInfoModelInDays.toDomainModel() = WeatherWindInfoModelInDayDomain(
    weatherSpeed = weatherSpeed,
    weatherDag = weatherDag,
    weatherGust = weatherGust
)