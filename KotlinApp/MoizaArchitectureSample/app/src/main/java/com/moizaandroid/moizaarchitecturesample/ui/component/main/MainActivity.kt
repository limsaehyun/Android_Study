package com.moizaandroid.moizaarchitecturesample.ui.component.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.moizaandroid.moizaarchitecturesample.R
import com.moizaandroid.moizaarchitecturesample.databinding.ActivityMainBinding
import com.moizaandroid.moizaarchitecturesample.ui.base.BaseActivity
import com.moizaandroid.moizaarchitecturesample.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding> (
    R.layout.activity_main
) {
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btn.setOnClickListener {
            vm.fetchPost(1)
        }
    }

    override fun observeEvent() {
        observe(vm.postData, ::setData)
    }

    fun setData(postData: String) {
        binding.tvResult.text = postData
    }
}