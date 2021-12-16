package com.saehyun.devicetoken

import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var token: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("sFile1",MODE_PRIVATE);
        editor = sharedPreferences.edit()

        getToken()

        setToken()

    }

    private fun setToken() {
        token = sharedPreferences.getString("DeviceToken", token)

        val tv = findViewById<TextView>(R.id.tv)
        tv.text = token
    }

    private fun getToken() {
        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener { task ->
            if(!task.isSuccessful) {
                Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
                return@addOnCompleteListener
            }

            token = task.getResult()?.token

            editor.putString("DeviceToken", token)
            editor.commit()
        }
    }
}