package com.github.posko.service.authentication.domain.interactor.session

import com.github.posko.service.authentication.domain.gateway.SessionGateway
import com.github.posko.core.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.interactor.Interactor
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
        appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: SessionGateway
) : Interactor<LogoutUseCase.Response, Unit>(appCoroutineDispatcher) {

    override suspend fun start(param: Unit): Response {
        gateway.signOut()
        return Response()
    }

    class Response
}