package com.saehyun.retrofitrxjava

import io.reactivex.Observable
import retrofit2.http.GET

interface Server {

    @GET("posts/1")
    fun getPost(): Observable<Respoonse>


}