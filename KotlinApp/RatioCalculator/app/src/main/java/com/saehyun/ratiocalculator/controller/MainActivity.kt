package com.saehyun.ratiocalculator.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.saehyun.ratiocalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var select: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                select = binding.sp.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.btnNext.setOnClickListener {
            if(select.isNotEmpty()) {
                var intent: Intent = Intent(applicationContext, CalculationActivity::class.java)
                intent.putExtra("select", select)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "기종을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}