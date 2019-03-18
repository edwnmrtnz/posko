package com.github.posko.core.domain.interactor.authentication

import com.github.posko.core.domain.gateways.AuthenticationGateway
import com.github.posko.core.domain.interactor.session.CreateSessionUseCase
import com.github.posko.core.domain.interactor.user.SaveUserUseCase
import com.github.posko.core.domain.model.User
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                       private var gateway : AuthenticationGateway,
                                       private var createSessionUseCase: CreateSessionUseCase,
                                       private var saveUserUseCase: SaveUserUseCase): UseCase<LoginUseCase.Response, LoginUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        val user = gateway.login(param.domain, param.account, param.email, param.password)
        saveUserUseCase.execute(SaveUserUseCase.Param(user))
        createSessionUseCase.execute(CreateSessionUseCase.Param(user.id, param.domain, user.authToken, user.token))
        return Response(user)
    }

    data class Param(val domain : String,
                     val account : String,
                     val email : String,
                     val password : String)

    data class Response(val user : User)
}