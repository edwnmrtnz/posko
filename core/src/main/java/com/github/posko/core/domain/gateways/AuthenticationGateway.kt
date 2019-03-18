package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.User

interface AuthenticationGateway {

    fun login(domain : String, account : String, email : String, password : String) : User

    fun logout()
}