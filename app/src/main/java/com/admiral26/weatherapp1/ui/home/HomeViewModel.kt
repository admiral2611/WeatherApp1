package com.admiral26.weatherapp1.ui.home

import androidx.lifecycle.LiveData
import com.admiral26.weatherapp1.core.model.current.CurrentResponse
import com.admiral26.weatherapp1.core.model.forecast.ForecastResponse

interface HomeViewModel {
    val getCurrent: LiveData<CurrentResponse?>
    val getForecast: LiveData<ForecastResponse?>
    fun getCurrentWeather(q: String)
    fun getForecastWeather(q: String)
}