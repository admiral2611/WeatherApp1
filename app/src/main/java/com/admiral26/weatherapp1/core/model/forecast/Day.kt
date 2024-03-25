package com.admiral26.weatherapp1.core.model.forecast


import com.admiral26.weatherapp1.core.model.forecast.ConditionX
import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avghumidity")
    val avghumidity: Int, // 68
    @SerializedName("avgtemp_c")
    val avgtempC: Double, // 12.5
    @SerializedName("avgtemp_f")
    val avgtempF: Double, // 54.5
    @SerializedName("avgvis_km")
    val avgvisKm: Double, // 9.4
    @SerializedName("avgvis_miles")
    val avgvisMiles: Double, // 5.0
    @SerializedName("condition")
    val condition: ConditionX,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Int, // 93
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: Int, // 0
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int, // 1
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int, // 0
    @SerializedName("maxtemp_c")
    val maxtempC: Double, // 14.8
    @SerializedName("maxtemp_f")
    val maxtempF: Double, // 58.7
    @SerializedName("maxwind_kph")
    val maxwindKph: Double, // 31.0
    @SerializedName("maxwind_mph")
    val maxwindMph: Double, // 19.2
    @SerializedName("mintemp_c")
    val mintempC: Double, // 10.7
    @SerializedName("mintemp_f")
    val mintempF: Double, // 51.2
    @SerializedName("totalprecip_in")
    val totalprecipIn: Double, // 0.08
    @SerializedName("totalprecip_mm")
    val totalprecipMm: Double, // 2.04
    @SerializedName("totalsnow_cm")
    val totalsnowCm: Double, // 0.0
    @SerializedName("uv")
    val uv: Double // 3.0
)