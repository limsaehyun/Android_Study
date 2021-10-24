package com.saehyun.getfeed.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saehyun.getfeed.repository.Repository
import com.saehyun.getfeed.viewModel.MainViewModel
import retrofit2.Response

class MainViewModelFactory(
    private val repository : Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}