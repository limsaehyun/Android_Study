package com.saehyun.ratiocalculator.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.saehyun.ratiocalculator.databinding.ActivityCalculationBinding
import com.saehyun.ratiocalculator.model.PhoneSize
import kotlin.math.*

class CalculationActivity : AppCompatActivity() {
    private val TAG = "CalculationActivity"

    private lateinit var Phone: String

    private var VerticalSize = 0
    private var HorizontalSize = 0

    private var phoneSize: PhoneSize = PhoneSize()

    private lateinit var binding: ActivityCalculationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Phone = intent.getStringExtra("select").toString()

        getSize()

        binding.tvCheckHorizontal.setOnClickListener {
            if(binding.etDP.text.isNotEmpty()) {
                val RESULT = binding.etDP.text.toString().toDouble() / HorizontalSize.toDouble()
                binding.tvResult.setText("${round(RESULT*100)/100}")
            }
        }

        binding.tvCheckVertical.setOnClickListener {
            if(binding.etDP.text.isNotEmpty()) {
                val RESULT = binding.etDP.text.toString().toDouble() / VerticalSize.toDouble()
                binding.tvResult.setText("${round(RESULT*100)/100}")
            }
        }
    }

    private fun getSize() {
        when(Phone) {
            "Galaxy S9" -> {
                VerticalSize = phoneSize.GalaxtS9Vertical
                HorizontalSize = phoneSize.GalaxyS9Horizontal
            }
        }
    }

}