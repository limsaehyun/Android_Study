package com.saehyun.roomexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saehyun.roomexample.database.LoginEntity
import com.saehyun.roomexample.database.LoginDatabase
import com.saehyun.roomexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var db: LoginDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = LoginDatabase.getInstance(applicationContext)!!
        refreshLogin()

        binding.btn.setOnClickListener {
            addLogin()
            refreshLogin()
            startLogin()
        }
    }

    private fun startLogin() {
        startActivity(Intent(applicationContext, SuccessActivity::class.java))
    }

    private fun addLogin() {
        val username = binding.etID.text.toString()
        val password = binding.etPW.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            db.loginDao().insetLogin(LoginEntity(username, password))
        }
    }

    private fun refreshLogin() {
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async {
                db.loginDao().getLogin()
            }.await()

            if(data != null) {
                binding.etID.setText("${data.username}")
                binding.etPW.setText("${data.password}")
            }
        }
    }
}