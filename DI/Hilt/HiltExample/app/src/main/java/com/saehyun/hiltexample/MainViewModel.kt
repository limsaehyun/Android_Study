package com.saehyun.hiltexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val rp: MainRepository,
    state : SavedStateHandle
) : ViewModel() {

    val success: MutableLiveData<String> = MutableLiveData()
    val error: MutableLiveData<Int> = MutableLiveData()

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "default"
    }

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