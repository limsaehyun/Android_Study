package com.saehyun.hiltexample

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val rp: MainRepository,
) : ViewModel() {

    val success: MutableLiveData<String> = MutableLiveData()
    val error: MutableLiveData<Int> = MutableLiveData()

    fun getPost() {
        rp.getPost().subscribe { response ->
            if (response.isSuccessful) {
                success.value = response.body()?.title
            } else {
                error.value = response.code()
            }
        }
    }
}