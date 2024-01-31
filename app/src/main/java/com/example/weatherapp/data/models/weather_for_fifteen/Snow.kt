package com.example.weatherapp.data.models.weather_for_fifteen


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Snow(
    @SerializedName("3h")
    val h: Double
): Serializable