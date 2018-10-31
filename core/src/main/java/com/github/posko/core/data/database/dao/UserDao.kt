package com.github.posko.core.data.database.dao


import androidx.room.Dao
import androidx.room.Query
import com.github.posko.core.data.database.model.UserData

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE email=:email")
    fun getUser(email : String) : UserData
}