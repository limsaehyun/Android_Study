package com.example.cpscheck

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.cpscheck.databinding.ActivityCPSBinding

class CPSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCPSBinding
    private var Sum = 0

    companion object {
        var CPS:Double = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCPSBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mCountDOwn.start()

        binding.ivCat.setOnClickListener {
            Sum++
            binding.tvClickNum.setText("" + Sum)
        }
    }

    private val mCountDOwn : CountDownTimer = object :CountDownTimer(10000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            binding.tvCount.setText("" + millisUntilFinished / 1000)
        }

        override fun onFinish() {
            CPS = binding.tvClickNum.text.toString().toDouble() / 10
            finish()
            startActivity(Intent(this@CPSActivity, ResultActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

    }

}