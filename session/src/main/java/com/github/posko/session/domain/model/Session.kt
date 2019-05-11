package com.github.posko.session.domain.model

data class Session (
        val userId : Int,
        val domain : String,
        val token : String,
        val status : String
)