package com.admiral26.weatherapp1.core.service

import com.admiral26.weatherapp1.core.model.current.CurrentResponse
import com.admiral26.weatherapp1.core.model.forecast.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/v1/current.json")
    suspend fun getCurrentWeather(
        @Query("q") q: String,
        @Query("lang") lang: String,
        @Query("key") key: String,
    ): Response<CurrentResponse?>

    @GET("/v1/forecast.json")
    suspend fun getForecast(
        @Query("key") apiKey: String,
        @Query("q") q: String,
        @Query("aqi") aqi: String,
        @Query("days") days: String,
        @Query("lang")lang: String
    ): Response<ForecastResponse?>
}