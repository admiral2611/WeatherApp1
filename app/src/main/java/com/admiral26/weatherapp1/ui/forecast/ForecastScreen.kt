package com.admiral26.weatherapp1.ui.forecast

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.weatherapp1.R
import com.admiral26.weatherapp1.core.adapter.ForecastAdapter
import com.admiral26.weatherapp1.core.adapter.HorizontalViewAdapter
import com.admiral26.weatherapp1.core.base.BaseFragment
import com.admiral26.weatherapp1.core.model.forecast.Day
import com.admiral26.weatherapp1.core.model.forecast.Forecastday
import com.admiral26.weatherapp1.core.model.forecast.Hour
import com.admiral26.weatherapp1.databinding.ScreenForecastBinding
import com.admiral26.weatherapp1.ui.home.HomeViewModel
import com.admiral26.weatherapp1.ui.home.HomeViewModelImp
import com.admiral26.weatherapp1.util.convertDateStringToDay
import com.admiral26.weatherapp1.util.iconWeather
import kotlin.math.log

class ForecastScreen : BaseFragment(R.layout.screen_forecast) {
    private val binding by viewBinding(ScreenForecastBinding::bind)
    private val adapter by lazy { ForecastAdapter() }
    private val args: ForecastScreenArgs by navArgs()
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImp>()

    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        observe()
        setAdapter()
        viewModel.getForecastWeather("${args.lat} ${args.lon}")
        setUi()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setUi() {
    }

    private fun setAdapter() {
        binding.rvListForecast.adapter = adapter
        binding.rvListForecast.layoutManager = LinearLayoutManager(context)

    }

    private fun observe() {
        viewModel.getForecast.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setData(it.forecast.forecastday)
                binding.tomorrowText.text = convertDateStringToDay(it.forecast.forecastday[1].date)
                binding.tomorrowWeatherValue.text = "${it.forecast.forecastday[1].day.avgtempC} °"
                binding.tomorrowWeatherIcon.iconWeather(it.forecast.forecastday[1].day.condition.icon)
                binding.tomorrowSunrise.text = it.forecast.forecastday[1].astro.sunrise
                binding.tomorrowSunset.text = it.forecast.forecastday[1].astro.sunset
            }
        }
    }
}