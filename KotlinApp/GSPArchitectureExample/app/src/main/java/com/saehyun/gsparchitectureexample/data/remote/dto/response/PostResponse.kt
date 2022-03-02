package com.saehyun.gsparchitectureexample.data.remote.dto.response

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)