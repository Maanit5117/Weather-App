package com.example.weatherapp

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.Response

class WeatherViewModel: ViewModel() {

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage
    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val weatherData: StateFlow<WeatherResponse?> = _weatherData
    private val weatherApi = API_Interface.create()

    fun fetchWeather(city: String, apiKey: String) {
        if (city.isBlank()) {
            _errorMessage.value = "Please enter a city name"
            return
        }

        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(city, apiKey)
                _weatherData.value = response
                _errorMessage.value = ""
            } catch (e: java.io.IOException) {
                _weatherData.value = null
                _errorMessage.value = "No internet connection"
            } catch (e: retrofit2.HttpException) {
                _weatherData.value = null
                if (e.code() == 404) _errorMessage.value = "City not found"
                else _errorMessage.value = "Something went wrong"
            }catch (e: Exception) {
                _weatherData.value = null
                _errorMessage.value = "Something went wrong"
            }
        }
    }


    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

