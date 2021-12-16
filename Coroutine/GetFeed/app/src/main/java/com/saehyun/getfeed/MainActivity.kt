package com.saehyun.getfeed

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saehyun.getfeed.databinding.ActivityMainBinding
import com.saehyun.getfeed.repository.Repository
import com.saehyun.getfeed.viewModel.MainViewModel
import com.saehyun.getfeed.viewModel.viewModelFactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnGetFeed.setOnClickListener {
            if(binding.etNum.text.isEmpty()) {
                Toast.makeText(this, "입력값이 없습니다!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.getPost(binding.etNum.text.toString().toInt())
            viewModel.postResponse.observe(this, Observer {
                if(it.isSuccessful) {
                    binding.tvTitle.text = it.body()?.title
                    binding.tvBody.text = it.body()?.body
                    binding.tvId.text = it.body()?.id.toString()
                    binding.tvUserId.text = it.body()?.userId.toString()
                } else {
                    Toast.makeText(this, "서버와의 통신에 실패하였습니다.\n다시 시도해주세요!", Toast.LENGTH_SHORT).show()

                }
            })
        }
    }
}