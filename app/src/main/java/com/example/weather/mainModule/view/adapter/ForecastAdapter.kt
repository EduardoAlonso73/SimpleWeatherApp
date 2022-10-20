package com.example.weather.mainModule.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.BR
import com.example.weather.R
import com.example.weather.common.entities.HourlyForecast
import com.example.weather.databinding.ItemWeatherBinding


class ForecastAdapter(private val listener: onClickListener) :
    ListAdapter<HourlyForecast, RecyclerView.ViewHolder>(ForecastDiffCallbacks()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val forecast=getItem(position)
        with(holder as ViewHolder){
            holder.binding?.setVariable(BR.forecast,forecast)
            holder.binding?.executePendingBindings()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)
        fun setListener(forecast: HourlyForecast) {
           listener.onClick(forecast)
        }
    }

}

class ForecastDiffCallbacks : DiffUtil.ItemCallback<HourlyForecast>() {

    override fun areItemsTheSame(oldItem: HourlyForecast, newItem: HourlyForecast): Boolean =oldItem.dt==newItem.dt

    override fun areContentsTheSame(oldItem: HourlyForecast, newItem: HourlyForecast): Boolean =oldItem.dt==newItem.dt
}