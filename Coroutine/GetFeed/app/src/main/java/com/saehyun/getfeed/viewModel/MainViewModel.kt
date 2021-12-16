package com.saehyun.getfeed.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.getfeed.model.Post
import com.saehyun.getfeed.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val postResponse : MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(number : Int) {
        viewModelScope.launch {
            val response = repository.getPost(number)
            postResponse.value = response
        }
    }

}