package com.github.posko.session.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.github.posko.session.data.db.model.UserData

@Dao
interface UserDao : BaseDao<UserData> {

    @Query("SELECT * FROM users WHERE id=:userId")
    fun getById(userId : Int) : UserData?

    @Query("DELETE FROM users")
    fun destroy()

}