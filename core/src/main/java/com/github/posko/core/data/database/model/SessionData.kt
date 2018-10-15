package com.github.posko.core.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "sessions")
data class SessionData (

        @PrimaryKey
        private var id : String,

        private var domain : String,

        @ColumnInfo(name = "session_for")
        private var sessionFor : String,

        @ColumnInfo(name = "auth_token")
        private var authToken : String,

        @ColumnInfo(name = "token")
        private var token : String

)