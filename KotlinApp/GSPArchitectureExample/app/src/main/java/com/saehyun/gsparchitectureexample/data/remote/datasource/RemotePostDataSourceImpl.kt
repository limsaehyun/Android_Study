package com.saehyun.gsparchitectureexample.data.remote.datasource

import com.saehyun.gsparchitectureexample.data.remote.dto.response.PostResponse
import com.saehyun.gsparchitectureexample.data.remote.network.PostApi
import com.saehyun.gsparchitectureexample.data.remote.network.ResultWrapper
import com.saehyun.gsparchitectureexample.data.remote.network.safeApiCall
import com.saehyun.gsparchitectureexample.di.module.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
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