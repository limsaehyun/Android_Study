package com.moizaandroid.moizaarchitecturesample.data.remote.datasource

import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.network.ResultWrapper
import com.moizaandroid.moizaarchitecturesample.utils.ApiException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

interface RemotePostDataSource {

    suspend fun fetchPost(id: Int): ResultWrapper<PostResponse?>
}