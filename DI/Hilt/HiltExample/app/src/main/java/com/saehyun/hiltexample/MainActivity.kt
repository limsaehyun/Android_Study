package com.saehyun.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.getPost()

        vm.success.observe(this, {
            Toast.makeText(applicationContext, "${it}", Toast.LENGTH_SHORT).show()
        })
        vm.error.observe(this, {
            Toast.makeText(applicationContext, "${it}", Toast.LENGTH_SHORT).show()
        })
    }
}