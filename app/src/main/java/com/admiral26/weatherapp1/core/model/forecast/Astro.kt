package com.admiral26.weatherapp1.core.model.forecast


import com.google.gson.annotations.SerializedName

data class Astro(
    @SerializedName("is_moon_up")
    val isMoonUp: Int, // 1
    @SerializedName("is_sun_up")
    val isSunUp: Int, // 0
    @SerializedName("moon_illumination")
    val moonIllumination: Int, // 91
    @SerializedName("moon_phase")
    val moonPhase: String, // Waxing Gibbous
    @SerializedName("moonrise")
    val moonrise: String, // 03:44 PM
    @SerializedName("moonset")
    val moonset: String, // 05:14 AM
    @SerializedName("sunrise")
    val sunrise: String, // 06:16 AM
    @SerializedName("sunset")
    val sunset: String // 06:30 PM
)