package com.admiral26.weatherapp1.core.model.forecast


import com.google.gson.annotations.SerializedName

data class AirQuality(
    @SerializedName("co")
    val co: Double, // 247.0
    @SerializedName("gb-defra-index")
    val gbDefraIndex: Int, // 1
    @SerializedName("no2")
    val no2: Double, // 0.6
    @SerializedName("o3")
    val o3: Double, // 101.6
    @SerializedName("pm10")
    val pm10: Double, // 4.9
    @SerializedName("pm2_5")
    val pm25: Double, // 1.1
    @SerializedName("so2")
    val so2: Double, // 0.2
    @SerializedName("us-epa-index")
    val usEpaIndex: Int // 1
)