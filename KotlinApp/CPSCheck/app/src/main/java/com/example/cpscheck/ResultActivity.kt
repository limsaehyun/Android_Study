package com.example.cpscheck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cpscheck.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCPS.setText("" + CPSActivity.CPS)

        binding.btnRestart.setOnClickListener {
            startActivity(Intent(this, CPSActivity::class.java))
        }
    }
}

