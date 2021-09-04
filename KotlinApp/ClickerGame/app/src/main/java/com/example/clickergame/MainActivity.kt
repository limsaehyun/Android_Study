package com.example.clickergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickergame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var Sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ib.setOnClickListener {
            Sum++
            binding.tv.setText("" + Sum)
        }
    }
}