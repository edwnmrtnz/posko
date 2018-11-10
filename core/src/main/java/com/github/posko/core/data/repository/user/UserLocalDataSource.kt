package com.github.posko.core.data.repository.user

import com.github.posko.core.data.database.dao.UserDao
import com.github.posko.core.data.extension.toUserData
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure
import java.lang.Exception
import java.lang.IllegalStateException

class UserLocalDataSource (private val dao : UserDao): UserGateway {
    override suspend fun saveUser(user: User) {
        try {
            dao.insert(user.toUserData())
        } catch (e : Exception) {
            throw IllegalStateException("Failed to insert user: " + e.message)
        }
    }

    override suspend fun login(domain : String, account_name: String, email: String, password: String): Either<Failure, User> {
        throw IllegalStateException("Should not be called")
    }
}