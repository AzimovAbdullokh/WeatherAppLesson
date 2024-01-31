package com.example.weatherapp.domain.use_cases

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.models.weather_for_fifteen.ListWeather

interface GetWeatherForFifteenDays {

    suspend operator fun invoke():  ResultStatus<List<ListWeather>>

}