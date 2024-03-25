package com.admiral26.weatherapp1.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.weatherapp1.R
import com.admiral26.weatherapp1.R.color.white
import com.admiral26.weatherapp1.core.adapter.HorizontalViewAdapter
import com.admiral26.weatherapp1.core.base.BaseFragment
import com.admiral26.weatherapp1.core.model.forecast.Hour
import com.admiral26.weatherapp1.databinding.ScreenHomeBinding
import com.admiral26.weatherapp1.util.iconWeather
import com.google.android.gms.common.api.ResolvableApiException
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.tasks.Task
import com.tozny.crypto.android.BuildConfig


@AndroidEntryPoint
class HomeScreen : BaseFragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImp>()
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private val adapter by lazy { HorizontalViewAdapter() }

    @SuppressLint("ResourceAsColor")
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        check()
        observe()
        setAdapter()

    }

    private fun setAdapter() {
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.setHasFixedSize(true)
    }

    private fun observe() {
        viewModel.getCurrent.observe(viewLifecycleOwner) {
            it?.let {
                binding.cityName.text = it.location.country
                binding.countryName.text = it.location.name
                binding.date.text = it.current.lastUpdated
                binding.humidityValue.text = it.current.humidity.toString()
                binding.weatherNumericValue.text = it.current.feelslikeC.toString()
                binding.atmosphericPressureValue.text = it.current.pressureIn.toString()
                binding.windValue.text = it.current.windKph.toString()
                binding.weatherIcon.iconWeather(it.current.condition.icon)
                binding.weatherType.text = it.current.condition.text
                binding.progresWeath.visibility = View.GONE
            }
        }

        viewModel.getForecast.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setData(it.forecast.forecastday[0].hour)
            }
        }
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun checkGPSEnabled(): Boolean {
        var isOn = false
        val context = requireContext().applicationContext
        val manager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER).not()) {
            isOn = true
        }
        return isOn
    }

    private fun check() {
        if (hasLocationPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if (checkGPSEnabled()) {
                    turnOnGPS()
                } else {
                    getLastLocation()
                }
            } else {
                getLastLocation()
            }
        } else {
            multiplePermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION

                )
            )
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient!!.lastLocation.addOnCompleteListener {
            if (it.isSuccessful) {
                val location = it.result

                //lat lon Buvayda ("40.6471326,71.0942634")
                viewModel.getCurrentWeather("${location.latitude} ${location.longitude}")
                viewModel.getForecastWeather("${location.latitude} ${location.longitude}")
                binding.next7days.setOnClickListener {
                    findNavController().navigate(
                        HomeScreenDirections.actionHomeScreenToForecastScreen(
                            location.latitude.toString(),
                            location.longitude.toString()
                        )
                    )
                }

            }
        }
    }

    private fun turnOnGPS() {
        val request = LocationRequest.create().apply {
            interval = 2000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        val builder = LocationSettingsRequest.Builder().addLocationRequest(request)
        val client: SettingsClient = LocationServices.getSettingsClient(requireActivity())
        val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())
        task.addOnFailureListener {
            if (it is ResolvableApiException) {
                try {
                    it.startResolutionForResult(requireActivity(), 101)
                } catch (_: IntentSender.SendIntentException) {
                }
            }
        }.addOnSuccessListener {
        }
    }

    private fun showCostumeDialog(
        title: String,
        message: String,
        ok: String,
        okBtn: DialogInterface.OnClickListener,
        cancel: String,
        cancelBtn: DialogInterface.OnClickListener
    ) {
        AlertDialog.Builder(requireContext()).setTitle(title).setMessage(message)
            .setPositiveButton(ok, okBtn)
            .setNegativeButton(cancel, cancelBtn).create().show()
    }

    private val multiplePermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->
            var finePermissionAllowed = false
            if (result[Manifest.permission.ACCESS_FINE_LOCATION] != null) {
                finePermissionAllowed = true
                if (finePermissionAllowed) {
                    getLastLocation()
                } else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {

                        showCostumeDialog(
                            "Location Permission",
                            "This app needs the location permission to track your location !!",
                            "ok",
                            { _, _ ->
                                val intent = Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.parse("package:${BuildConfig.APPLICATION_ID}")
                                )
                                startActivity(intent)
                            },
                            "Cancel"
                        ) { dialog, _ -> dialog?.cancel() }
                    }
                }
            }
        }

}