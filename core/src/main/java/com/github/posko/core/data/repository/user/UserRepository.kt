package com.github.posko.core.data.repository.user

import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Error

class UserRepository(private val local: UserGateway, private val remote : UserGateway) : UserGateway {

    override suspend fun login(account_name: String, email: String, password: String): Either<Error, User> {
        return remote.login(account_name, email, password)
    }
}