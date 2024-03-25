package com.admiral26.weatherapp1.core.model.current


import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("code")
    val code: Int, // 1003
    @SerializedName("icon")
    val icon: String, // //cdn.weatherapi.com/weather/64x64/day/116.png
    @SerializedName("text")
    val text: String // Переменная облачность
)