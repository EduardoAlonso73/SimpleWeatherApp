package com.example.weather.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.weather.BR
import com.example.weather.R
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        setupViewModel()
        setupObserver()
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

    override  fun onStart(){
        super.onStart()
        lifecycleScope.launch{
        mBinding.viewModel.getWeatherForecast(21.136886, -98.411143,"fae1ee3214e784a6aedf3cb84f5a8665","metric","en")

        }
    }
}