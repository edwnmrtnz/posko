package com.edwnmrtnz.posko.sdk.auth.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.edwnmrtnz.posko.sdk.auth.data.db.model.SessionData

@Dao
interface SessionDao : BaseDao<SessionData> {

    @Query("SELECT * FROM sessions WHERE status = 'active' LIMIT 1")
    fun getActiveSession() : SessionData?
}