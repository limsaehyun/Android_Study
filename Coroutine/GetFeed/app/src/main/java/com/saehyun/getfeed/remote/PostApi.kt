package com.saehyun.getfeed.remote

import com.saehyun.getfeed.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("posts/{post_id}")
    suspend fun getPost(
        @Path("post_id") number : Int
    ) : Response<Post>
}