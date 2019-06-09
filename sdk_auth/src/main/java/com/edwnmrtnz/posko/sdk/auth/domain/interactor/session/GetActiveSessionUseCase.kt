package com.edwnmrtnz.posko.sdk.auth.domain.interactor.session

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.SessionGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.Session
import javax.inject.Inject

/**
 * throws NoActiveSessionException if no session
 * found
 */
class GetActiveSessionUseCase
    @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : SessionGateway): Interactor<GetActiveSessionUseCase.Response, Unit> (appCoroutineDispatcher){

    override suspend fun start(param: Unit): Response {
        return Response(gateway.getActiveSession())
    }

    class Response(val session : Session)
}