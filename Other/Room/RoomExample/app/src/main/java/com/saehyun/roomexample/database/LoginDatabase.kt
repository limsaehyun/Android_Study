package com.saehyun.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LoginEntity::class],
    version = 1,
    exportSchema = false
)

abstract class LoginDatabase: RoomDatabase() {
    abstract fun loginDao() : LoginDao

    companion object {
        private var instance: LoginDatabase? = null

        @Synchronized
        fun getInstance(context: Context): LoginDatabase? {
            if (instance == null) {
                synchronized(LoginDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LoginDatabase::class.java,
                        "login-database"
                    )
                        .build()
                }
            }
            return instance
        }
    }
}