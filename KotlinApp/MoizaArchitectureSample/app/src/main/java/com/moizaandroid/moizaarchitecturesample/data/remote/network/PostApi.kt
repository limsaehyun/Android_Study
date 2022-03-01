package com.moizaandroid.moizaarchitecturesample.data.remote.network

import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("posts/{post-id}")
    suspend fun fetchPost(
        @Path("post-id") postId: Int
    ): Response<PostResponse>
}