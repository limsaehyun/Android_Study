package com.saehyun.getfeed.repository

import com.saehyun.getfeed.model.Post
import com.saehyun.getfeed.remote.ApiProvider
import retrofit2.Response

class Repository {
    suspend fun getPost(number : Int) : Response<Post> {
        return ApiProvider.postApi.getPost(number)
    }
}