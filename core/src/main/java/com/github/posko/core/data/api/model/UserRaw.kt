package com.github.posko.core.data.api.model

data class UserRaw(
        var id : Int,
        var email : String,
        var first_name : String?,
        var last_name : String?,
        var token : String,
        var auth_token : String,
        var created_at : String)