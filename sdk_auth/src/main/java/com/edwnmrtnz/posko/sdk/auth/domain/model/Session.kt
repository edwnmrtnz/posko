package com.edwnmrtnz.posko.sdk.auth.domain.model

data class Session (
        val userId : Int,
        val domain : String,
        val token : String,
        val status : String
)