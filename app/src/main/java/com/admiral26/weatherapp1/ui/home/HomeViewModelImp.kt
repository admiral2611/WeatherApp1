package com.admiral26.weatherapp1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.weatherapp1.core.di.repo.WeatherRepository
import com.admiral26.weatherapp1.core.model.current.CurrentResponse
import com.admiral26.weatherapp1.core.model.forecast.ForecastResponse
import com.admiral26.weatherapp1.util.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImp @Inject constructor(
    private val repository: WeatherRepository
) : HomeViewModel, ViewModel() {
    private val _getCurrent = MutableLiveData<CurrentResponse?>()
    private val _getForecast = MutableLiveData<ForecastResponse?>()

    override val getCurrent: LiveData<CurrentResponse?> = _getCurrent
    override val getForecast: LiveData<ForecastResponse?> = _getForecast

    override fun getCurrentWeather(q: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCurrent(q)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getCurrent.postValue(result.response)
                }
            }
        }
    }

    override fun getForecastWeather(q: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getForecast(q)) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    _getForecast.postValue(result.response)
                }
            }
        }
    }
}