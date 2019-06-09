package com.edwnmrtnz.posko.sdk.auth.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData (
        @PrimaryKey val id : Int,
        val account_id : Int?,
        val email : String,
        val first_name : String,
        val last_name : String,
        val middle_name : String?,
        val suffix : String?,
        val status : String,
        val user_status : String?
)