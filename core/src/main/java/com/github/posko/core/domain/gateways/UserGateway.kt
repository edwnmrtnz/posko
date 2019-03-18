package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.User

interface UserGateway {

    fun saveUser(user : User)
}