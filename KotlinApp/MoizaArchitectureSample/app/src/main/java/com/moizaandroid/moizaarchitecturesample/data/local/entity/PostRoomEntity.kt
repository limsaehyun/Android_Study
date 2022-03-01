package com.moizaandroid.moizaarchitecturesample.data.local.entity

import androidx.room.Entity
import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse

@Entity (tableName = "postEntity")
data class PostRoomEntity(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostRoomEntity.toResponse() =
    PostResponse(
        body = body,
        id = id,
        title = title,
        userId = userId
    )