package com.github.posko.core.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.github.posko.core.data.database.model.UserData

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE email=:email")
    fun getUser(email : String) : UserData
}