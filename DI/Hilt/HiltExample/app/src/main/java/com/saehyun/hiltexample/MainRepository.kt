package com.saehyun.hiltexample

import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MainRepository {

    fun getPost() : @NonNull Single<Response<PostResponse>> =
        postApi.getPost()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
}