package com.github.posko.core.domain.interactor.user

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.interactor.Interactor
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure

class LoginUserUseCase (dispatcher: AppCoroutineDispatcher,
                        private var gateway: UserGateway) : Interactor<User, LoginUserUseCase.Param>(dispatcher) {

    override suspend fun run(params: Param): Either<Failure, User> {
        return gateway.login(params.accountName, params.email, params.password)
    }

    data class Param(var accountName : String, var email : String, var password : String)
}