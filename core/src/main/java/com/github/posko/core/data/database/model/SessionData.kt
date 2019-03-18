package com.github.posko.core.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "sessions")
data class SessionData (
        @PrimaryKey
        var id : Int,
        var domain : String,
        var auth_token : String,
        var token : String
)