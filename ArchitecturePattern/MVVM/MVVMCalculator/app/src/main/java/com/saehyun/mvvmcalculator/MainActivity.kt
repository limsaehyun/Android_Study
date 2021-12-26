package com.saehyun.mvvmcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saehyun.mvvmcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var vm = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observeEvent()

        binding.run {
            btn.setOnClickListener {
                val num1 = et1.text.toString().toInt()
                val num2 = et2.text.toString().toInt()
                if(num1 != 0 && num2 != 0) {
                    vm.plus(MainData(num1, num2))
                }
            }
        }
    }

    private fun observeEvent() {
        vm.toastmessage.observe(this, {
            binding.result.text = it.toString()
            Toast.makeText(applicationContext, "${it}", Toast.LENGTH_SHORT).show()
        })
    }
}