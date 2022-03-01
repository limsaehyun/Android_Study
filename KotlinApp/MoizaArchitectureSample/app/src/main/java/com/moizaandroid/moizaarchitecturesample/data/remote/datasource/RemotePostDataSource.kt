package com.moizaandroid.moizaarchitecturesample.data.remote.datasource

import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.network.error.ResultWrapper

interface RemotePostDataSource {

    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?>
}