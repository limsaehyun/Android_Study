package com.saehyun.hiltexample

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts/1")
    fun getPost() : Single<Response<PostResponse>>
}