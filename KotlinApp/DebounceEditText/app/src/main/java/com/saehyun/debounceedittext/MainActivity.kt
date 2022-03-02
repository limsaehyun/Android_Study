package com.saehyun.debounceedittext

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etDebounceTest = findViewById<DebouncedTextInputEditText>(R.id.etDebounceTest)


        etDebounceTest.setOnDebounceTextWatcher(lifecycle) { input ->
            run {
                if (input.isNotEmpty()) {
                    lifecycleScope.launchWhenCreated {
                        Log.d(TAG, "debounce text watcher: $input")
                    }
                }
            }
        }
    }
}