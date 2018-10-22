package com.github.posko.core.data.database.dao

import android.arch.persistence.room.Query
import com.github.posko.core.data.database.model.SessionData

interface SessionDao {

    @Query("SELECT * from sessions LIMIT 1")
    fun getSession() : SessionData?
}