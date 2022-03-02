package com.saehyun.gsparchitectureexample.data.remote.datasource

import com.saehyun.gsparchitectureexample.data.remote.dto.response.PostResponse
import com.saehyun.gsparchitectureexample.data.remote.network.ResultWrapper

interface RemotePostDataSource {

    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?>
}