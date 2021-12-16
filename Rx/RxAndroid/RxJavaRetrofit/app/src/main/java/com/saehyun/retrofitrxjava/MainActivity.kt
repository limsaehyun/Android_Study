package com.saehyun.retrofitrxjava

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.saehyun.retrofitrxjava.ApiProvider.buildService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable.add(
                ApiProvider.buildService().getPost()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ response ->
                            Log.d(TAG, "onCreate: $response")
                        }, { t ->
                            Log.d(TAG, "onCreate: $t")
                        }))
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.clear()
    }
}