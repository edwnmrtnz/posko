package com.github.posko.service.authentication.domain.interactor.session

import com.github.posko.service.authentication.domain.gateway.SessionGateway
import com.github.posko.service.authentication.domain.interactor.user.SaveUserUseCase
import com.github.posko.service.authentication.domain.model.Session
import com.github.posko.service.authentication.domain.model.User
import com.github.posko.core.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.interactor.Interactor
import javax.inject.Inject

class LoginUseCase @Inject constructor(
        appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: SessionGateway,
        private var saveSessionUseCase: SaveSessionUseCase,
        private var saveUserUseCase: SaveUserUseCase
) : Interactor<LoginUseCase.Response, LoginUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        val userWithCookie = gateway.signIn(
                param.domain,
                param.accountName,
                param.email,
                param.password
        )

        val session = Session(userWithCookie.user.id, param.domain, userWithCookie.cookie, "active")
        val user = userWithCookie.user

        saveSessionUseCase.execute(SaveSessionUseCase.Param(session))
        saveUserUseCase.execute(SaveUserUseCase.Param(user))

        return Response(user)
    }

    data class Param(val domain: String,
                     val accountName: String,
                     val email: String,
                     val password: String)

    data class Response(val user: User)
}