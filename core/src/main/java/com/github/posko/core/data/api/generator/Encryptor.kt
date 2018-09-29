package com.github.posko.core.data.api.generator

interface Encryptor {

    fun basicAuthentication(username : String, password: String) : String
}