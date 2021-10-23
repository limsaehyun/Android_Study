package com.saehyun.corotineretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private fun getRetrofit() : Retrofit {
        val baseURL = "https://jsonplaceholder.typicode.com/posts/1"

        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiServce(): UserAPI {
        return getRetrofit().create(UserAPI::class.java)
    }
}