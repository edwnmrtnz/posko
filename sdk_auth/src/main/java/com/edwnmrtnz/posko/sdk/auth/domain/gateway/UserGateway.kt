package com.edwnmrtnz.posko.sdk.auth.domain.gateway

import com.edwnmrtnz.posko.sdk.auth.domain.model.User

interface UserGateway {

    fun save (user : User)

    fun getById(userId : Int) : User

    fun destroy()
}