package com.github.posko.service.authentication.domain.interactor.session

import com.github.posko.service.authentication.domain.gateway.SessionGateway
import com.github.posko.service.authentication.domain.model.Session
import com.github.posko.core.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.interactor.Interactor
import javax.inject.Inject

class SaveSessionUseCase @Inject constructor (
    appCoroutineDispatcher: AppCoroutineDispatcher,
    private var gateway: SessionGateway
) : Interactor<SaveSessionUseCase.Response, SaveSessionUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        gateway.save(param.session)
        return Response()
    }

    data class Param(val session: Session)

    class Response
}