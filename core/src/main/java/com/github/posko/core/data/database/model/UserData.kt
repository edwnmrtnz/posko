package com.github.posko.core.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData (
        @PrimaryKey
        var id : Int,
        var email : String,
        var first_name: String?,
        var last_name : String?,
        var token : String,
        var auth_token : String,
        var created_at : String
)