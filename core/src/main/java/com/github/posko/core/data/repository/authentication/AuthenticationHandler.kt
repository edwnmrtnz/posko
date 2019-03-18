package com.github.posko.core.data.repository.authentication

import com.github.posko.core.data.api.services.login.LoginServices
import com.github.posko.core.data.extension.toDomain
import com.github.posko.core.domain.gateways.AuthenticationGateway
import com.github.posko.core.domain.model.User

class AuthenticationHandler(private val services: LoginServices) : AuthenticationGateway {

    override suspend fun login(domain: String, account: String, email: String, password: String): User {
        val userRaw = services.login(domain, account, email, password)
        return userRaw.toDomain()
    }

    override suspend fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}