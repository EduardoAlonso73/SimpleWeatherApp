package com.example.weather.mainModule.view.adapter

import com.example.weather.common.entities.HourlyForecast

interface onClickListener {
    fun onClick(forecast: HourlyForecast)
}