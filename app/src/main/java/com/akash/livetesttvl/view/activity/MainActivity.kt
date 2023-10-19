package com.akash.livetesttvl.view.activity

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.akash.livetesttvl.databinding.ActivityMainBinding
import com.akash.livetesttvl.utils.changeButtonUI
import java.text.DecimalFormat
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    var price = 0.0
    private var binding: ActivityMainBinding? = null
    private val mHandler = Handler()
    private val mRunnable = object : Runnable {
        override fun run() {
            updatePriceAndPercentage()
            mHandler.postDelayed(this, 5000)
        }
    }

    private fun updatePriceAndPercentage() {
        val changedPrice = (0..6000000).random().toDouble()
        val changedPercentage = abs((changedPrice / price) * 100.0)

        binding!!.amount.text = DecimalFormat("#.##").format(changedPrice).toString()
        binding!!.amount2.text = DecimalFormat("#.##").format(changedPrice).toString()
        binding!!.amount3.text = DecimalFormat("#.##").format(changedPrice).toString()

        if ((changedPrice - price) < 0) {
            binding!!.percent.text = "${DecimalFormat("#.##").format(changedPercentage)} %"
            binding!!.percent.setTextColor(Color.GREEN)
            binding!!.percent2.text = "${DecimalFormat("#.##").format(changedPercentage)} %"
            binding!!.percent2.setTextColor(Color.GREEN)
        } else {
            binding!!.percent.text = "-${DecimalFormat("#.##").format(changedPercentage)} %"
            binding!!.percent.setTextColor(Color.RED)
            binding!!.percent2.text = "-${DecimalFormat("#.##").format(changedPercentage)} %"
            binding!!.percent2.setTextColor(Color.RED)
        }
        price = changedPrice
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.homeBtn.setOnClickListener {
            changeButtonUI.home(binding!!)
        }

        binding!!.detailsBtn.setOnClickListener {
            changeButtonUI.details(binding!!)
        }

        mHandler.postDelayed(mRunnable, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }
}