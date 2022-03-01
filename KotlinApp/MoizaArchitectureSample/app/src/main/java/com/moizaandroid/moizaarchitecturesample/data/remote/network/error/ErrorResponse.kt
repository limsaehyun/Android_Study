package com.moizaandroid.moizaarchitecturesample.data.remote.network.error

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val errorMessage: String
)
