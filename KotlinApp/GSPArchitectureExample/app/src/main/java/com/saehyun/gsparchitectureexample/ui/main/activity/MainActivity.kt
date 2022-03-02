package com.saehyun.gsparchitectureexample.ui.main.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import kotlinx.coroutines.flow.collect
import com.saehyun.gsparchitectureexample.R
import com.saehyun.gsparchitectureexample.databinding.ActivityMainBinding
import com.saehyun.gsparchitectureexample.ui.base.BaseActivity
import com.saehyun.gsparchitectureexample.ui.main.model.PostModel
import com.saehyun.gsparchitectureexample.ui.main.viewmodel.MainViewModel
import com.saehyun.gsparchitectureexample.utils.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: MainViewModel.Event) = when (event) {
        is MainViewModel.Event.FetchPost -> {
            setPost(event.postData)
        }
        is MainViewModel.Event.ErrorMessage -> {
            Toast.makeText(applicationContext, event.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setPost(data: PostModel) {
        binding.tvResult.text = data.title
    }

    override fun initView() {
        binding.btn.setOnClickListener {
            vm.fetchPost(1)
        }
    }
}