package com.weatherapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weatherapp.ui.MainActivityViewModel
import com.weatherapp.ui.adapeter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel : MainActivityViewModel by viewModels()
    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLocation()
        setupRecyclerView()

        collectLatestLifecycleFlow(viewModel.flowLocation){
            "${getString(R.string.lat)} ${it.lat}".also { latTv.text = it }
            "${getString(R.string.lon)} ${it.long}".also { lonTv.text = it }

        }

        collectLatestLifecycleFlow(viewModel.flowHourlyWeatherList){
            when(it){
                is MainActivityViewModel.AnswerState.Success ->{
                    weatherAdapter.differ.submitList(it.hourlyList)
                }
            }

        }

    }

    private fun setupRecyclerView() {
        weatherAdapter = WeatherAdapter()
        hourlyWeatherRv.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(baseContext)
        }
    }

    private fun getLocation(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_REQUEST_ACCESS_FINE_LOCATION)
            return
        }

        viewModel.setEventState(MainActivityViewModel.EventState.GetLocation(baseContext))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_ACCESS_FINE_LOCATION) {
            when (grantResults[0]) {
                PackageManager.PERMISSION_GRANTED -> getLocation()
                PackageManager.PERMISSION_DENIED -> {}//Tell to user the need of grant permission
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_ACCESS_FINE_LOCATION = 100
    }
}

fun <T> AppCompatActivity.collectLatestLifecycleFlow(flow : Flow<T>, collect: suspend (T) -> Unit){
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            flow.collectLatest(collect)

        }
    }

}
























