package com.github.posko.service.authentication.domain.interactor.session

import com.github.posko.service.authentication.domain.gateway.SessionGateway
import com.github.posko.service.authentication.domain.model.Session
import com.github.posko.base.service.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.service.interactor.Interactor
import javax.inject.Inject

/**
 * throws NoActiveSessionException if no session
 * found
 */
class GetActiveSessionUseCase @Inject constructor (
        appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: SessionGateway
) : Interactor<GetActiveSessionUseCase.Response, Unit>(appCoroutineDispatcher) {

    override suspend fun start(param: Unit): Response {
        return Response(gateway.getActiveSession())
    }

    class Response(val session: Session)
}