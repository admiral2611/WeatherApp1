package com.admiral26.weatherapp1.core.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.weatherapp1.core.model.forecast.Forecastday
import com.admiral26.weatherapp1.databinding.ItemForecastBinding
import com.admiral26.weatherapp1.util.convertDateStringToDay
import com.admiral26.weatherapp1.util.iconWeather

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {
    private val data = ArrayList<Forecastday>()
    var onClicked: ((actorId: Int) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Forecastday>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ForecastViewHolder(private val binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindData(data: Forecastday) {

            binding.dataForecast.text = convertDateStringToDay(data.date)
            binding.iconForecast.iconWeather(data.day.condition.icon)
            binding.tempCValue.text = data.day.avgtempC.toString()
            val childAdapter = HorizontalViewAdapter()
            binding.rvListItem.adapter = childAdapter
            binding.rvListItem.layoutManager =
                LinearLayoutManager(
                    binding.iconForecast.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            childAdapter.setData(data.hour)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            ItemForecastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}