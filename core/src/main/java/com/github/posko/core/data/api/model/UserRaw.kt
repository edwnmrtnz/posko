package com.github.posko.core.data.api.model

data class UserRaw(private var email : String,
                   private var first_name : String?,
                   private var last_name : String?,
                   private var token : String,
                   private var auth_token : String,
                   private var created_at : String)