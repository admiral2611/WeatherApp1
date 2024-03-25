package com.admiral26.weatherapp1.core.model.forecast


import com.google.gson.annotations.SerializedName

data class Forecastday(
    @SerializedName("astro")
    val astro: Astro,
    @SerializedName("date")
    val date: String, // 2024-03-22
    @SerializedName("date_epoch")
    val dateEpoch: Int, // 1711065600
    @SerializedName("day")
    val day: Day,
    @SerializedName("hour")
    val hour: List<Hour>
)