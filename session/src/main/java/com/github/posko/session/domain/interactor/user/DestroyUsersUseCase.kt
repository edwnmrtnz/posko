package com.github.posko.session.domain.interactor.user

import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.Interactor
import com.github.posko.session.domain.gateway.UserGateway
import javax.inject.Inject

class DestroyUsersUseCase @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                                      private var gateway : UserGateway): Interactor<DestroyUsersUseCase.Response, Unit>(appCoroutineDispatcher) {
    override suspend fun start(param: Unit): Response {
        gateway.destroy()
        return Response()
    }

    class Response
}