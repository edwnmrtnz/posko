package com.github.posko.session.domain.interactor.session

import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.Interactor
import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.session.domain.model.Session
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