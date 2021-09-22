package com.example.spim.controller.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spim.R
import com.example.spim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}