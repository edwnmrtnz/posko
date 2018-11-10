package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure

interface UserGateway {

    suspend fun login(domain : String, account_name : String, email : String, password : String) : Either<Failure, User>

    suspend fun saveUser(user : User)
}