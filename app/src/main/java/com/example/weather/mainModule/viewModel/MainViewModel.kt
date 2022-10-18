package com.example.weather.mainModule.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R

import com.example.weather.common.entities.WeatherForecastEnt
import com.example.weather.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val repository = MainRepository()

    private  val result=MutableLiveData<WeatherForecastEnt>()
    fun getResult():LiveData<WeatherForecastEnt> = result


    private val snapshotMgs=MutableLiveData<Int>()
    fun getSnapshotMgs() = snapshotMgs

    private  val loader=MutableLiveData<Boolean>()
    fun isLoading()= loader

    suspend fun getWeatherForecast(lat:Double,Log:Double,appId:String,units:String,lang:String){
        viewModelScope.launch {
            try {
                loader.value=true
                val resultSever=repository.getWeatherForecast(lat,Log,appId,units,lang)
                result.value=resultSever
            }catch (e:Exception){
                snapshotMgs.value= R.string.main_error_server

            }finally {
                loader.value=false
            }
        }
    }



}