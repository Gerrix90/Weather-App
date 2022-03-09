package com.weatherapp.ui.adapeter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.R
import com.weatherapp.service.model.hourly_weather.Hourly
import kotlinx.android.synthetic.main.weather_item.view.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Hourly>() {
        override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem.dt == newItem.dt
        }

        override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.weather_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Hourly) -> Unit)? = null

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherItem = differ.currentList[position]
        holder.itemView.apply {
            val formatter = DateTimeFormatter.ofPattern("HH:mm");
            val instant = Instant.ofEpochMilli(weatherItem.dt.toLong() * 1000)
            val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            "Hour: ${formatter.format(date)}".also { hourTv.text = it }
            var k = weatherItem.temp
            var c = k -273.15
            "Temp: ${c.toInt()}".also { tempTv.text = it }
            "Humidity: ${weatherItem.humidity}".also { humTv.text = it }
            "Wind Speed: ${weatherItem.windSpeed}".also { windSpeedTv.text = it }

            setOnClickListener {
                onItemClickListener?.let { it(weatherItem) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Hourly) -> Unit) {
        onItemClickListener = listener
    }

}