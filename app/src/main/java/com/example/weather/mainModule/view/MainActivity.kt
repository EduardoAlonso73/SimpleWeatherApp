package com.example.weather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.BR
import com.example.weather.R
import com.example.weather.common.entities.HourlyForecast
import com.example.weather.common.utils.CommonUtils
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.mainModule.view.adapter.ForecastAdapter
import com.example.weather.mainModule.view.adapter.onClickListener
import com.example.weather.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),onClickListener {

    private lateinit var mBinding:ActivityMainBinding
    private lateinit var adapter:ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        setupViewModel()
        setupObserver()
        setupAdapter()
        setuRecyclerView()
    }

    private fun setupViewModel() {
        val vm:MainViewModel by viewModels()
        mBinding.lifecycleOwner=this
        mBinding.setVariable(BR.viewModel,vm)
    }

    private fun setupObserver() {
        mBinding.viewModel?.let {
            it.getSnapshotMgs().observe(this){resMsg->
                Snackbar.make(mBinding.root,resMsg,Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun setupAdapter() {
        adapter= ForecastAdapter(this)
    }

    private fun setuRecyclerView() {
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=this@MainActivity.adapter
        }
    }

    override  fun onStart(){
        super.onStart()
        lifecycleScope.launch{
            mBinding.viewModel?.getWeatherForecast(19.4325, -99.1332,"fae1ee3214e784a6aedf3cb84f5a8665","metric","en")

        }
    }

    override fun onClick(forecast: HourlyForecast) {
      Snackbar.make(mBinding.root,CommonUtils.getFullData(forecast.dt),Snackbar.LENGTH_LONG).show()
    }
}