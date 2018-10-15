package com.github.posko.core.domain.model

data class User(private var email : String,
                private var firstName: String?,
                private var lastName : String?,
                private var token : String,
                private var authToken : String,
                private var createdAt: String)