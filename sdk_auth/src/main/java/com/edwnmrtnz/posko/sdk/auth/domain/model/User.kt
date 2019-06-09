package com.edwnmrtnz.posko.sdk.auth.domain.model

data class User (val id : Int,
                 val accountId : Int?,
                 val email : String,
                 val firstName : String,
                 val lastName : String,
                 val middleName : String?,
                 val suffix : String?,
                 val status : String,
                 val userStatus : String?)