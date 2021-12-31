package com.saehyun.roomexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {

    @Query("Select * From LoginEntity")
    fun getLogin() : LoginEntity

    @Query("DELETE From LoginEntity")
    fun deleteLogin()

    @Insert
    fun insetLogin(loginEntity: LoginEntity)

}