package com.saehyun.roomexample.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.PipedWriter

@Entity
data class Login(
    val username: String,
    val password: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
