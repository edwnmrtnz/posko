package com.github.posko.session.domain.interactor.user

import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.Interactor
import com.github.posko.session.domain.gateway.UserGateway
import com.github.posko.session.domain.model.User
import javax.inject.Inject

class GetUserByIdUseCase
    @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : UserGateway): Interactor<GetUserByIdUseCase.Response, GetUserByIdUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        val user = gateway.getById(param.userId)
        return Response(user)
    }

    data class Param(val userId : Int)

    data class Response(val user : User)
}