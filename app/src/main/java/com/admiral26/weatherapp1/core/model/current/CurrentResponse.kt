package com.admiral26.weatherapp1.core.model.current


import com.google.gson.annotations.SerializedName

data class CurrentResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location
)