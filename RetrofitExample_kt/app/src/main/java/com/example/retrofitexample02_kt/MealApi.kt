package com.example.retrofitexample02_kt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MealApi {
    @GET("/event/meal/{datetime}")
    fun getMeal(@Path("datetime") dateTime:String):Call<MealResponse>

}