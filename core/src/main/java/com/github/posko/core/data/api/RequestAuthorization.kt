package com.github.posko.core.data.api

interface RequestAuthorization {

    fun getDomain() : String

    fun getUsername() : String

    fun getPassword() : String
}