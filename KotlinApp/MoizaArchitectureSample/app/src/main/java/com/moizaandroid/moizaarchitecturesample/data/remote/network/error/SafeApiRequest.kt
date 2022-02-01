package com.moizaandroid.moizaarchitecturesample.data.remote.network.error

import com.squareup.moshi.Moshi
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ResultWrapper<T?> {
    return try {
        val response = apiCall.invoke()
        return ResultWrapper.Success(response.body())
    }catch (throwable: Throwable){
        when(throwable){
            is IOException -> ResultWrapper.NetworkError
            is HttpException -> {
                val code = throwable.code()
                val errorResponse = convertErrorBody(throwable)
                ResultWrapper.GenericError(code, errorResponse)
            }
            else -> ResultWrapper.GenericError(null, null)
        }
    }
}

private fun convertErrorBody(throwable: HttpException) : ErrorResponse?{
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val adap = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            adap.fromJson(it)
        }
    }catch (e: Exception){
        null
    }
}