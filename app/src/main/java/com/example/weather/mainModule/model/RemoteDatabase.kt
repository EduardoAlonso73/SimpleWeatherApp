package com.example.weather.mainModule.model

import com.example.weather.common.dataAccess.WeatherService
import com.example.weather.common.entities.WeatherForecastEnt
import com.example.weather.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDatabase {
    private val retrofit=Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private  val service=retrofit.create(WeatherService::class.java)

    suspend fun getWeatherForecastByCoordinates(lat:Double,log:Double,appId:String,units:String,lang:String):WeatherForecastEnt{
        return withContext(Dispatchers.IO){ service.getWeatherForecastByCoodinates(lat,log,appId,units,lang) }
    }
}