package com.admiral26.weatherapp1.core.model.current


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("cloud")
    val cloud: Int, // 37
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelslikeC: Double, // 11.8
    @SerializedName("feelslike_f")
    val feelslikeF: Double, // 53.2
    @SerializedName("gust_kph")
    val gustKph: Double, // 35.2
    @SerializedName("gust_mph")
    val gustMph: Double, // 21.9
    @SerializedName("humidity")
    val humidity: Int, // 72
    @SerializedName("is_day")
    val isDay: Int, // 1
    @SerializedName("last_updated")
    val lastUpdated: String, // 2024-03-22 16:30
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int, // 1711107000
    @SerializedName("precip_in")
    val precipIn: Double, // 0.0
    @SerializedName("precip_mm")
    val precipMm: Double, // 0.0
    @SerializedName("pressure_in")
    val pressureIn: Double, // 30.03
    @SerializedName("pressure_mb")
    val pressureMb: Double, // 1017.0
    @SerializedName("temp_c")
    val tempC: Double, // 14.0
    @SerializedName("temp_f")
    val tempF: Double, // 57.2
    @SerializedName("uv")
    val uv: Double, // 4.0
    @SerializedName("vis_km")
    val visKm: Double, // 10.0
    @SerializedName("vis_miles")
    val visMiles: Double, // 6.0
    @SerializedName("wind_degree")
    val windDegree: Int, // 180
    @SerializedName("wind_dir")
    val windDir: String, // S
    @SerializedName("wind_kph")
    val windKph: Double, // 15.1
    @SerializedName("wind_mph")
    val windMph: Double // 9.4
)