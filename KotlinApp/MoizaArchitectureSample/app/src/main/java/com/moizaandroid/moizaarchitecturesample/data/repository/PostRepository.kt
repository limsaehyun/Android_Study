package com.moizaandroid.moizaarchitecturesample.data.repository

import com.moizaandroid.moizaarchitecturesample.data.local.datasource.LocalPostDataSource
import com.moizaandroid.moizaarchitecturesample.data.remote.datasource.RemotePostDataSource
import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.network.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remotePostDataSource: RemotePostDataSource
){
    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?> =
        remotePostDataSource.fetchPost(id)
}