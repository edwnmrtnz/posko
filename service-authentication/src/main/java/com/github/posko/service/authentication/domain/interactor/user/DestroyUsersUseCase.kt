package com.github.posko.service.authentication.domain.interactor.user

import com.github.posko.service.authentication.domain.gateway.UserGateway
import com.github.posko.base.service.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.service.interactor.Interactor
import javax.inject.Inject

class DestroyUsersUseCase @Inject constructor(
        appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: UserGateway
) : Interactor<DestroyUsersUseCase.Response, Unit>(appCoroutineDispatcher) {
    override suspend fun start(param: Unit): Response {
        gateway.destroy()
        return Response()
    }

    class Response
}