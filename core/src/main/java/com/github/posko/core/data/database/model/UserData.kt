package com.github.posko.core.data.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class UserData (

        @PrimaryKey
        var email : String,

        @ColumnInfo(name = "first_name")
        var firstName: String?,

        @ColumnInfo(name = "last_name")
        var lastName : String?,

        var token : String,

        @ColumnInfo(name = "auth_token")
        var authToken : String,

        @ColumnInfo(name = "created_at")
        var createdAt : String
)