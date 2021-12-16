package com.example.spim.controller.activity

import android.content.Intent
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

        binding.btnLoad.setOnClickListener {
            binding.tvName.setText("${EditActivity.user.name}")
            binding.tvGrade.setText("${EditActivity.user.grade}")
            binding.tvClass.setText("${EditActivity.user.Class}")
            binding.tvNumber.setText("${EditActivity.user.number}")
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }
}