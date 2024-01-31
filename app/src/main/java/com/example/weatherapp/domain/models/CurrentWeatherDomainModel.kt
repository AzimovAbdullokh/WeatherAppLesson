package com.example.weatherapp.domain.models

data class CurrentWeatherDomainModel(
    val weatherId:Int,
    val weatherMain:String,
    val weatherDescription:String,
)