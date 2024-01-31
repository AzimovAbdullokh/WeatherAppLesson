package com.example.weatherapp.data.models.weather_for_fifteen

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WeatherForFifteenDaysRemote(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<ListWeather>,
    @SerializedName("message")
    val message: Int
): Serializable