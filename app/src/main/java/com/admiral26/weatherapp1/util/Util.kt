package com.admiral26.weatherapp1.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Locale

const val BASE_URL = "https://api.weatherapi.com/"
const val API_KEY = "abc250afba9c435489b60858241702"


fun ImageView.iconWeather(url: String) {
    Glide.with(this.context)
        .load("https:${url}")
        .into(this)
}

fun extractTimeFromString(dateTimeString: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = inputFormat.parse(dateTimeString)
        outputFormat.format(date!!)
    } catch (e: Exception) {
        ""
    }
}

fun convertDateStringToDay(dateString: String): String? {
    try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val date = inputFormat.parse(dateString)

        if (date != null) {
            val outputFormat = SimpleDateFormat("EEEE", Locale.US)
            return outputFormat.format(date)
        }
    } catch (_: Exception) {}

    return ""
}