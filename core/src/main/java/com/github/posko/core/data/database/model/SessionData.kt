package com.github.posko.core.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "sessions")
data class SessionData (

        @PrimaryKey
        var id : String,

        var domain : String,

        @ColumnInfo(name = "session_for")
        var sessionFor : String,

        @ColumnInfo(name = "auth_token")
        var authToken : String,

        @ColumnInfo(name = "token")
        var token : String

)