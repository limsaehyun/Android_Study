package com.saehyun.gsparchitectureexample.data.repository

import com.saehyun.gsparchitectureexample.data.remote.datasource.RemotePostDataSource
import com.saehyun.gsparchitectureexample.data.remote.dto.response.PostResponse
import com.saehyun.gsparchitectureexample.data.remote.network.ResultWrapper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteMainDataSource: RemotePostDataSource
){
    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?> =
        remoteMainDataSource.fetchPost(id)
}