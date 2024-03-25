package com.admiral26.weatherapp1.core.model.forecast


import com.google.gson.annotations.SerializedName

data class ConditionXX(
    @SerializedName("code")
    val code: Int, // 1153
    @SerializedName("icon")
    val icon: String, // //cdn.weatherapi.com/weather/64x64/night/266.png
    @SerializedName("text")
    val text: String // Слабая морось
)