package com.moizaandroid.socketexample.model

data class MessageResponse(
    val client: String,
    val data: Data
) {
    data class Data(
        val data: String
    )
}