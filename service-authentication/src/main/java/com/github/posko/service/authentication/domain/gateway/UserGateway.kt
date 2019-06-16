package com.github.posko.service.authentication.domain.gateway

import com.github.posko.service.authentication.domain.model.User

interface UserGateway {

    fun save(user: User)

    fun getById(userId: Int): User

    fun destroy()
}