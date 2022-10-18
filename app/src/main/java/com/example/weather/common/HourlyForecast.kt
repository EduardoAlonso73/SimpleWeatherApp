package com.example.weather.common

data class Forecast(val dt:Long,
                    val humidity:Int,
                    val temp:Double,
                    val weather:List<Weather>,
                    val pop:Double):WeatherBase(dt,humidity,temp,weather)
