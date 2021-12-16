package com.saehyun.getfeed.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    private var BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postApi : PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }
}