package com.admiral26.weatherapp1.core.model.forecast


import com.google.gson.annotations.SerializedName

data class ConditionX(
    @SerializedName("code")
    val code: Int, // 1063
    @SerializedName("icon")
    val icon: String, // //cdn.weatherapi.com/weather/64x64/day/176.png
    @SerializedName("text")
    val text: String // Местами дождь
)