package com.moizaandroid.moizaarchitecturesample.data.repository

import com.moizaandroid.moizaarchitecturesample.data.remote.datasource.RemotePostDataSource
import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.network.error.ResultWrapper
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remotePostDataSource: RemotePostDataSource
){
    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?> =
        remotePostDataSource.fetchPost(id)
}