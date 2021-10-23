package com.saehyun.corotineretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = RetrofitObject.getApiServce().getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = RetrofitObject.getApiServce().getPosts()
        }
    }
}