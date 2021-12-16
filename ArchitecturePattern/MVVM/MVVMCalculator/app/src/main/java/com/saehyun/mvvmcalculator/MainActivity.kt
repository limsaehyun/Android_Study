package com.saehyun.mvvmcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.saehyun.mvvmcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.run {
            btn.setOnClickListener {
                val num1 = et1.text.toString()
                val num2 = et2.text.toString()
                if(num1.isNotEmpty() && num2.isNotEmpty()) {

                }
            }
        }
    }
}