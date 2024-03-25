package com.admiral26.weatherapp1.core.model.current


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("country")
    val country: String, // Uzbekistan
    @SerializedName("lat")
    val lat: Double, // 40.65
    @SerializedName("localtime")
    val localtime: String, // 2024-03-22 16:36
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int, // 1711107388
    @SerializedName("lon")
    val lon: Double, // 71.09
    @SerializedName("name")
    val name: String, // Buyvaydy
    @SerializedName("region")
    val region: String, // Farghona
    @SerializedName("tz_id")
    val tzId: String // Asia/Tashkent
)