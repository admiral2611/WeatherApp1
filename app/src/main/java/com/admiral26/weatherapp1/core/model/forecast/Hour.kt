package com.admiral26.weatherapp1.core.model.forecast


import com.admiral26.weatherapp1.core.model.forecast.ConditionXX
import com.google.gson.annotations.SerializedName

data class Hour(
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int, // 100
    @SerializedName("chance_of_snow")
    val chanceOfSnow: Int, // 0
    @SerializedName("cloud")
    val cloud: Int, // 93
    @SerializedName("condition")
    val condition: ConditionXX,
    @SerializedName("dewpoint_c")
    val dewpointC: Double, // 7.8
    @SerializedName("dewpoint_f")
    val dewpointF: Double, // 46.0
    @SerializedName("feelslike_c")
    val feelslikeC: Double, // 9.9
    @SerializedName("feelslike_f")
    val feelslikeF: Double, // 49.7
    @SerializedName("gust_kph")
    val gustKph: Double, // 25.5
    @SerializedName("gust_mph")
    val gustMph: Double, // 15.8
    @SerializedName("heatindex_c")
    val heatindexC: Double, // 11.9
    @SerializedName("heatindex_f")
    val heatindexF: Double, // 53.4
    @SerializedName("humidity")
    val humidity: Int, // 76
    @SerializedName("is_day")
    val isDay: Int, // 0
    @SerializedName("precip_in")
    val precipIn: Double, // 0.02
    @SerializedName("precip_mm")
    val precipMm: Double, // 0.62
    @SerializedName("pressure_in")
    val pressureIn: Double, // 30.02
    @SerializedName("pressure_mb")
    val pressureMb: Double, // 1016.0
    @SerializedName("snow_cm")
    val snowCm: Double, // 0.0
    @SerializedName("temp_c")
    val tempC: Double, // 11.9
    @SerializedName("temp_f")
    val tempF: Double, // 53.4
    @SerializedName("time")
    val time: String, // 2024-03-22 00:00
    @SerializedName("time_epoch")
    val timeEpoch: Int, // 1711047600
    @SerializedName("uv")
    val uv: Double, // 1.0
    @SerializedName("vis_km")
    val visKm: Double, // 2.0
    @SerializedName("vis_miles")
    val visMiles: Double, // 1.0
    @SerializedName("will_it_rain")
    val willItRain: Int, // 1
    @SerializedName("will_it_snow")
    val willItSnow: Int, // 0
    @SerializedName("wind_degree")
    val windDegree: Int, // 249
    @SerializedName("wind_dir")
    val windDir: String, // WSW
    @SerializedName("wind_kph")
    val windKph: Double, // 19.1
    @SerializedName("wind_mph")
    val windMph: Double, // 11.9
    @SerializedName("windchill_c")
    val windchillC: Double, // 9.9
    @SerializedName("windchill_f")
    val windchillF: Double // 49.7
)