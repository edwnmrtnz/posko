package com.edwnmrtnz.posko.sdk.auth.data.api.model

data class UserRaw (
        val id : Int,
        val account_id : Int,
        val email : String,
        val first_name : String,
        val last_name : String,
        val middle_name : String?,
        val status : String,
        val suffix : String?,
        val title : String?,
        val user_status : String?,
        val user_type : String?
)