package com.github.posko.core.domain.model

data class User(var id : Int,
                var email : String,
                var firstName: String?,
                var lastName : String?,
                var token : String,
                var authToken : String,
                var createdAt: String)