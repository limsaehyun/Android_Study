package com.moizaandroid.moizaarchitecturesample.data.remote.datasource

import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.network.PostApi
import com.moizaandroid.moizaarchitecturesample.data.remote.network.ResultWrapper
import com.moizaandroid.moizaarchitecturesample.data.remote.network.safeApiCall
import com.moizaandroid.moizaarchitecturesample.di.module.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemotePostDataSourceImpl @Inject constructor(
    private val postApi: PostApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : RemotePostDataSource {

    override suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?> =
        safeApiCall {
            postApi.fetchPost(id)
        }
}