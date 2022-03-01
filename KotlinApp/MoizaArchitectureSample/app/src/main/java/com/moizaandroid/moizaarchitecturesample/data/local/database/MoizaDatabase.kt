package com.moizaandroid.moizaarchitecturesample.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moizaandroid.moizaarchitecturesample.data.local.dao.PostDao
import com.moizaandroid.moizaarchitecturesample.data.local.entity.PostRoomEntity

@Database(
    entities = [PostRoomEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MoizaDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}