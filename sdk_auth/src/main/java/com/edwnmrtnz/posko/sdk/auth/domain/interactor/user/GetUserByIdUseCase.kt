package com.edwnmrtnz.posko.sdk.auth.domain.interactor.user

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.UserGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.User
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