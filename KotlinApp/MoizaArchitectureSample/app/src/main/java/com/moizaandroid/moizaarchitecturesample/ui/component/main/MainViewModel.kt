package com.moizaandroid.moizaarchitecturesample.ui.component.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moizaandroid.moizaarchitecturesample.R
import com.moizaandroid.moizaarchitecturesample.data.remote.network.error.ResultWrapper
import com.moizaandroid.moizaarchitecturesample.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: PostRepository
) : ViewModel() {

    val postData = MutableLiveData<String>()
    val errorToast = MutableLiveData<String>()

    fun fetchPost(postId: Int) {
        viewModelScope.launch {
            val fetchPost = mainRepository.fetchPost(postId)
            when(fetchPost) {
                is ResultWrapper.NetworkError -> {
                    errorToast.value = R.string.error_network.toString()
                }
                is ResultWrapper.Failed -> {
                    errorToast.value = fetchPost.error?.errorMessage
                }
                is ResultWrapper.Success -> {
                    postData.value = fetchPost.value.toString()
                }
            }
        }
    }

}