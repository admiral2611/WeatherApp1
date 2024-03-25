package com.admiral26.weatherapp1.core.di.repoImp

import com.admiral26.weatherapp1.core.di.repo.WeatherRepository
import com.admiral26.weatherapp1.core.model.current.CurrentResponse
import com.admiral26.weatherapp1.core.model.forecast.ForecastResponse
import com.admiral26.weatherapp1.core.service.WeatherService
import com.admiral26.weatherapp1.util.API_KEY
import com.admiral26.weatherapp1.util.ResultWrapper
import com.admiral26.weatherapp1.util.parseResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherService
) : WeatherRepository {
    override suspend fun getCurrent(
        q: String
    ): ResultWrapper<CurrentResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getCurrentWeather(q, "ru", API_KEY)
        }
    }

    override suspend fun getForecast(
        q: String,
    ): ResultWrapper<ForecastResponse?, Any> {
        return parseResponse(Dispatchers.IO) {
            service.getForecast(API_KEY, q, "yes", "7", "ru")
        }
    }
}