package com.admiral26.weatherapp1.core.di.repo

import com.admiral26.weatherapp1.core.model.current.CurrentResponse
import com.admiral26.weatherapp1.core.model.forecast.ForecastResponse
import com.admiral26.weatherapp1.util.ResultWrapper

interface WeatherRepository {
    suspend fun getCurrent(
        q: String,
    ): ResultWrapper<CurrentResponse?, Any>

    suspend fun getForecast(
        q: String
    ): ResultWrapper<ForecastResponse?, Any>
}