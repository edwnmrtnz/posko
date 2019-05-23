package com.github.posko.session.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.github.posko.session.data.db.model.SessionData
import com.github.posko.session.domain.model.Session

@Dao
interface SessionDao : BaseDao<SessionData> {

    @Query("SELECT * FROM sessions WHERE status = 'active' LIMIT 1")
    fun getActiveSession() : SessionData?
}