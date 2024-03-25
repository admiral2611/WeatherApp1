package com.admiral26.weatherapp1.core.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.weatherapp1.R
import com.admiral26.weatherapp1.core.model.forecast.Hour
import com.admiral26.weatherapp1.databinding.WeatherTimeCardLayoutBinding
import com.admiral26.weatherapp1.util.convertDateStringToDay
import com.admiral26.weatherapp1.util.extractTimeFromString
import com.admiral26.weatherapp1.util.iconWeather
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class HorizontalViewAdapter : RecyclerView.Adapter<HorizontalViewAdapter.HorizontalViewHolder>() {
    private val data = ArrayList<Hour>()
    var onClicked: ((actorId: Int) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Hour>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class HorizontalViewHolder(private val binding: WeatherTimeCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindData(data: Hour) {
            binding.weatherIcon.iconWeather(data.condition.icon)
            binding.weatherValue.text = "${data.feelslikeC}°"

            //data da kelayotgan kun/oy/yil 09:00 soatini olib berish uchun
            val dateTimeString = data.time
            val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val outputFormat = DateTimeFormatter.ofPattern("HH:mm")
            val outputFormatData = DateTimeFormatter.ofPattern("yyyy-mm-dd")
            val dateTime = LocalDateTime.parse(dateTimeString, inputFormat)
            val timeOnly = dateTime.format(outputFormat)
            val dataOnly = dateTime.format(outputFormatData)
            binding.weatherTime.text = timeOnly


            val currentData = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("EEEE", Locale.US)
            val haftaKuni = dateFormat.format(currentData)
            Log.d("data11", "bindData: $haftaKuni")


            //telefondan vaxt olish uchun
            val currentTime = Calendar.getInstance().time
            val is24HourFormat = DateFormat.is24HourFormat(/*Context*/ binding.weatherTime.context)
            val timeFormat = if (is24HourFormat) "HH:00" else "hh:00"
            val formattedTime = DateFormat.format(timeFormat, currentTime)
            if (formattedTime == timeOnly && haftaKuni == convertDateStringToDay(dataOnly) ) {
                binding.smallWeatherCardParent.setBackgroundResource(R.drawable.active_weather_time_column_style)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(
            WeatherTimeCardLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}