package com.akash.livetesttvl.utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import com.akash.livetesttvl.R
import com.akash.livetesttvl.databinding.ActivityMainBinding

object changeButtonUI {
    fun home(binding: ActivityMainBinding) {
        binding.homeIcon.setBackgroundResource(R.drawable.home_colored_icon)
        binding.homeText.setTextColor(ColorStateList.valueOf(Color.GREEN))
        binding.detailsText.setTextColor(ColorStateList.valueOf(Color.GRAY))
        binding.detailsIcon.setBackgroundResource(R.drawable.details_icon)

        binding.content.visibility = View.VISIBLE
        binding.detailsView.visibility = View.INVISIBLE
    }
    fun details(binding: ActivityMainBinding) {
        binding.homeIcon.setBackgroundResource(R.drawable.home_icon)
        binding.homeText.setTextColor(ColorStateList.valueOf(Color.GRAY))
        binding.detailsText.setTextColor(ColorStateList.valueOf(Color.GREEN))
        binding.detailsIcon.setBackgroundResource(R.drawable.details_colored_icon)

        binding.content.visibility = View.INVISIBLE
        binding.detailsView.visibility = View.VISIBLE
    }
}