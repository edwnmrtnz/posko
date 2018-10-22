package com.github.posko.core.data.database.dao

import android.arch.persistence.room.Query

interface UserDao {

    @Query("SELECT * FROM users WHERE email=:email")
    fun getUser(email : String)
}