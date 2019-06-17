package com.github.posko.service.authentication.domain.interactor.user

import com.github.posko.service.authentication.domain.gateway.UserGateway
import com.github.posko.service.authentication.domain.model.User
import com.github.posko.toolkit.essentials.dispatcher.AppCoroutineDispatcher
import com.github.posko.toolkit.essentials.interactor.Interactor
import javax.inject.Inject

class SaveUserUseCase @Inject constructor (
        appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: UserGateway
) : Interactor<SaveUserUseCase.Response, SaveUserUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        gateway.save(param.user)
        return Response()
    }

    data class Param(val user: User)

    class Response
}