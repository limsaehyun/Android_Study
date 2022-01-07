package com.saehyun.datastoreexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.datastore.core.DataStore
import com.saehyun.datastoreexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.button.setOnClickListener {
            val text = binding.editText2.text.toString()

            if(text.isNotEmpty()) {
                setData(text)
            } else {
                Toast.makeText(applicationContext, "저장할 데이터를 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            ExampleApplication.getInstance().getDataStore().text.collect {
                binding.result.text = it
            }
        }
    }

    private fun setData(text: String) {
        CoroutineScope(Dispatchers.Main).launch {
            ExampleApplication.getInstance().getDataStore().setText(text)
        }
        Toast.makeText(applicationContext, "저장 완료!", Toast.LENGTH_SHORT).show()
    }
}