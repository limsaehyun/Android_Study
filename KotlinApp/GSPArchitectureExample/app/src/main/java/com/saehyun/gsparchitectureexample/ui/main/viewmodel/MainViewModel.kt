package com.saehyun.gsparchitectureexample.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.gsparchitectureexample.R
import com.saehyun.gsparchitectureexample.data.remote.dto.response.PostResponse
import com.saehyun.gsparchitectureexample.data.remote.network.ResultWrapper
import com.saehyun.gsparchitectureexample.data.repository.MainRepository
import com.saehyun.gsparchitectureexample.ui.main.model.PostModel
import com.saehyun.gsparchitectureexample.utils.MutableEventFlow
import com.saehyun.gsparchitectureexample.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun fetchPost(id: Int) {
        viewModelScope.launch {

            when (val fetchPost = mainRepository.fetchPost(id)) {
                is ResultWrapper.NetworkError -> {
                    event(Event.ErrorMessage("네트워크가 불안정합니다."))
                }
                is ResultWrapper.Failed -> {
                    event(Event.ErrorMessage(fetchPost.error?.errorMessage!!))
                }
                is ResultWrapper.Success -> {
                    event(Event.FetchPost(fetchPost.value!!.toModel()))
                }
            }
        }
    }

    fun PostResponse.toModel() =
        PostModel(
            body = body,
            id = id,
            title = title,
            userId = userId
        )

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    sealed class Event {
        data class FetchPost(val postData: PostModel) : Event()
        data class ErrorMessage(val message: String) : Event()
    }
}