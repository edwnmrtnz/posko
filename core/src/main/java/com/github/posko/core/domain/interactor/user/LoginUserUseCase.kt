package com.github.posko.core.domain.interactor.user

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.interactor.Interactor
import com.github.posko.core.domain.interactor.session.CreateSessionUseCase
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure

class LoginUserUseCase (dispatcher: AppCoroutineDispatcher,
                        private var userGateway: UserGateway,
                        private var createSessionUseCase: CreateSessionUseCase) : Interactor<User, LoginUserUseCase.Param>(dispatcher) {

    override suspend fun run(params: Param): Either<Failure, User> {
        val loginResult = userGateway.login(params.domain, params.accountName, params.email, params.password)
        return if(loginResult.isLeft) {
            loginResult
        } else {
            createSessionUseCase.execute(CreateSessionUseCase.Param(params.domain, (loginResult as Either.Right).data))
            loginResult
        }
    }

    data class Param(var domain : String,
                     var accountName : String,
                     var email : String,
                     var password : String)
}