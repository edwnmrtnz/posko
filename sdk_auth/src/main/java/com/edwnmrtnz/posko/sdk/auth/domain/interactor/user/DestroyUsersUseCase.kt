package com.edwnmrtnz.posko.sdk.auth.domain.interactor.user

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.UserGateway
import javax.inject.Inject

class DestroyUsersUseCase @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                                      private var gateway : UserGateway): Interactor<DestroyUsersUseCase.Response, Unit>(appCoroutineDispatcher) {
    override suspend fun start(param: Unit): Response {
        gateway.destroy()
        return Response()
    }

    class Response
}