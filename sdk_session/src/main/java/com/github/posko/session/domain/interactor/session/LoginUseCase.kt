package com.github.posko.session.domain.interactor.session

import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.Interactor
import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.session.domain.interactor.user.SaveUserUseCase
import com.github.posko.session.domain.model.Session
import com.github.posko.session.domain.model.User
import javax.inject.Inject

class LoginUseCase
    @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : SessionGateway,
                        private var saveSessionUseCase: SaveSessionUseCase,
                        private var saveUserUseCase: SaveUserUseCase): Interactor<LoginUseCase.Response, LoginUseCase.Param>(appCoroutineDispatcher) {

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

    data class Param(val domain : String,
                     val accountName : String,
                     val email : String,
                     val password : String)

    data class Response(val user : User)
}