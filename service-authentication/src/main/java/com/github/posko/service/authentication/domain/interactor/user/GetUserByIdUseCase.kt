package com.github.posko.service.authentication.domain.interactor.user

import com.github.posko.service.authentication.domain.gateway.UserGateway
import com.github.posko.service.authentication.domain.model.User
import com.github.posko.core.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.interactor.Interactor
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor (
        private var appCoroutineDispatcher: AppCoroutineDispatcher,
        private var gateway: UserGateway
) : Interactor<GetUserByIdUseCase.Response, GetUserByIdUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        val user = gateway.getById(param.userId)
        return Response(user)
    }

    data class Param(val userId: Int)

    data class Response(val user: User)
}