package com.saehyun.splashscreenexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SplashScreenExample)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}