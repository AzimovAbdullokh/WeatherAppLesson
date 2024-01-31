package com.example.weatherapp.data.models

import com.example.weatherapp.data.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDataModel(
    @SerializedName("coord")
    val weatherCoordinate: WeatherCoordinateModel,
    @SerializedName("weather")
    val weather: WeatherCloudModel,
    @SerializedName("base")
    val weatherBase: String,
    @SerializedName("main")
    val weatherMain: WeatherMainModel,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val weatherWindInfo: WeatherWindInfoModel,
    @SerializedName("clouds")
    val weatherClouds: WeatherCloudsModel,
    @SerializedName("name")
    val cityName: String,
) : Serializable {
    companion object {
        val unknown = WeatherDataModel(
            weatherBase = EMPTY_STRING,
            weather = WeatherCloudModel.unknown,
            weatherClouds = WeatherCloudsModel.unknown,
            weatherCoordinate = WeatherCoordinateModel.unknown,
            weatherMain = WeatherMainModel.unknown,
            weatherWindInfo = WeatherWindInfoModel.unknown,
            cityName = EMPTY_STRING,
            visibility = 0,
        )
    }
}




