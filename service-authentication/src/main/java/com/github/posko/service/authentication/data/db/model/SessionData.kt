package com.github.posko.service.authentication.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionData(
        @PrimaryKey val user_id: Int,
        val domain: String,
        val token: String,
        val status: String
)