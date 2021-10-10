package com.saehyun.ratiocalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.saehyun.ratiocalculator.databinding.ActivityCalculationBinding
import kotlin.math.*

class CalculationActivity : AppCompatActivity() {
    private val TAG = "CalculationActivity"

    private lateinit var Phone: String
    private var LengthSize = 0
    private var WidthSize = 0

    private var phoneSize: PhoneSize = PhoneSize()

    private lateinit var binding: ActivityCalculationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Phone = intent.getStringExtra("select").toString()

        getLengthSize()
        getWidthSize()

        binding.tvCheckLength.setOnClickListener {
            if(binding.etDP.text.isNotEmpty()) {
                val RESULT = binding.etDP.text.toString().toDouble() / LengthSize.toDouble()
                binding.tvResult.setText("${round(RESULT*100)/100}")
            }
        }
    }

    private fun getLengthSize() {
        when(Phone) {
            "Galaxy S9" -> LengthSize = phoneSize.GalaxyS9Length
        }
    }

    private fun getWidthSize() {
        when(Phone) {
            "Galaxt S9" -> WidthSize = phoneSize.GalaxtS9Width
        }
    }



}