package com.github.posko.core.data.database.dao


import androidx.room.Dao
import androidx.room.Query
import com.github.posko.core.data.database.dao.base.BaseDao
import com.github.posko.core.data.database.model.UserData

@Dao
interface UserDao : BaseDao<UserData> {

    @Query("SELECT * FROM users WHERE id=:id")
    fun getUser(id : Int) : UserData
}