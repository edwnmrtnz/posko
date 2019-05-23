package com.github.posko.session.domain.gateway

import com.github.posko.session.domain.model.User

interface UserGateway {

    fun save (user : User)

    fun getById(userId : Int) : User

    fun destroy()
}