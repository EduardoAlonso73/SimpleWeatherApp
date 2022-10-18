package com.example.weather.mainModule.model

import com.example.weather.common.entities.WeatherForecastEnt

class MainRepository {
    private val  remoteDatabase= RemoteDatabase()

    suspend fun getWeatherForecast(lat:Double,log:Double,appId:String,units:String,lang:String):WeatherForecastEnt{
        return remoteDatabase.getWeatherForecastByCoordinates(lat,log,appId,units,lang)
    }
}