package com.example.weatherapp.data.models.weather_for_fifteen


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sys(
    @SerializedName("pod")
    val pod: String
): Serializable