package com.edwnmrtnz.posko.sdk.auth.domain.interactor.session

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.SessionGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.Session
import javax.inject.Inject

class SaveSessionUseCase
    @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : SessionGateway) : Interactor<SaveSessionUseCase.Response, SaveSessionUseCase.Param> (appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        gateway.save(param.session)
        return Response()
    }

    data class Param(val session : Session)

    class Response
}