package com.example.weather.common.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.weather.R
import com.example.weather.common.entities.Weather


@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("weatheImg")
fun weather(img: ImageView, typeWeather: String) {
    val weather =listOf<String>("broken clouds", "scattered clouds", "overcast clouds", "few clouds","light rain")
    when (typeWeather) {
        weather[0],weather[1] -> img.setImageResource(R.drawable.ic_scatted_broke)
        weather[2]->img.setImageResource(R.drawable.ic_overcast)
        weather[3]->img.setImageResource(R.drawable.ic_few_clouds)
        weather[4]->img.setImageResource(R.drawable.ic_light_rain)
        else -> img.setImageResource(R.drawable.ic_strange_weather)
    }

}

@BindingAdapter("weatheBackground")
fun coloWeather(backgr: ConstraintLayout, typeWeather: String) {
    val weather =listOf<String>("broken clouds", "scattered clouds", "overcast clouds", "few clouds","light rain")
    when (typeWeather) {
        weather[0],weather[1] ->backgr.setBackgroundColor(Color.parseColor("#31C8FF"))
        weather[2]->backgr.setBackgroundColor(Color.parseColor("#989898"))
        weather[3]->backgr.setBackgroundColor(Color.parseColor("#FFDA74"))
        weather[4]->backgr.setBackgroundColor(Color.parseColor("#CACBCE"))
        else ->backgr.setBackgroundColor(Color.parseColor("#FD9E34"))
    }

}


