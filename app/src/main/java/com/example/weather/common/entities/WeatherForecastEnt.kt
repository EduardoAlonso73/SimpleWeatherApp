package com.example.weather.common.entities

data class WeatherForecastEnt(val timezone:String, val current: Current, val hourly: List<HourlyForecast>)
