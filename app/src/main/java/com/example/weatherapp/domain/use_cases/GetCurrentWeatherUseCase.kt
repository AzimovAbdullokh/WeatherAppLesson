package com.example.weatherapp.domain.use_cases

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel

interface GetCurrentWeatherUseCase {

    suspend operator fun invoke(): ResultStatus<WeatherDataDomainModel>

}