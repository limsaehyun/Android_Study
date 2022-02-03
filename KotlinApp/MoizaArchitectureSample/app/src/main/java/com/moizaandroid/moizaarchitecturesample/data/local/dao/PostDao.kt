package com.moizaandroid.moizaarchitecturesample.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.moizaandroid.moizaarchitecturesample.data.local.entity.PostRoomEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM postEntity")
    suspend fun fetchPost(): PostRoomEntity
}