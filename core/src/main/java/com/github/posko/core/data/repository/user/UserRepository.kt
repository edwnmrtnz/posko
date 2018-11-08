package com.github.posko.core.data.repository.user

import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure

class UserRepository(private val local: UserGateway, private val remote : UserGateway) : UserGateway {
    override suspend fun saveUser(user: User) {
        local.saveUser(user)
    }

    override suspend fun login(account_name: String, email: String, password: String): Either<Failure, User> {
        val result =  remote.login(account_name, email, password)
        return if(result is Either.Left) {
            result
        } else {
            val user = (result as Either.Right).data
            saveUser(user)
            result
        }
    }
}