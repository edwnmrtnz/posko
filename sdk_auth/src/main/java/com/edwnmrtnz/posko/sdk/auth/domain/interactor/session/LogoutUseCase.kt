package com.edwnmrtnz.posko.sdk.auth.domain.interactor.session

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.SessionGateway
import javax.inject.Inject

class LogoutUseCase
    @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : SessionGateway): Interactor<LogoutUseCase.Response, Unit>(appCoroutineDispatcher) {

    override suspend fun start(param: Unit): Response {
        gateway.signOut()
        return Response()
    }

    class Response
}