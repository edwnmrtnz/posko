package com.github.posko.core.data.database.dao


import androidx.room.Dao
import androidx.room.Query
import com.github.posko.core.data.database.dao.base.BaseDao
import com.github.posko.core.data.database.model.SessionData

@Dao
interface SessionDao : BaseDao<SessionData> {

    @Query("SELECT * from sessions LIMIT 1")
    fun getSession() : SessionData?
}