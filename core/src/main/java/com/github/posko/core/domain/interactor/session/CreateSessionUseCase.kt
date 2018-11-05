package com.github.posko.core.domain.interactor.session

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.interactor.CompletableInteractor
import com.github.posko.core.domain.model.Session
import com.github.posko.core.domain.model.User

class CreateSessionUseCase(var dispatcher: AppCoroutineDispatcher, var gateway: SessionGateway) : CompletableInteractor<CreateSessionUseCase.Param>(dispatcher) {

    override suspend fun run(params: Param) {
        val user = params.user
        val session = Session(user.id, params.domain, user.id, user.authToken, user.token)
        gateway.createSession(session)
    }

    data class Param(var domain : String, var user : User)
}

