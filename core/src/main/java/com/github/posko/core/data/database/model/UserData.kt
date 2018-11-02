package com.github.posko.core.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData (

        @PrimaryKey
        var id : Int,

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