package com.edwnmrtnz.posko.sdk.auth.domain.interactor.user

import com.github.posko.base.sdk.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.sdk.interactor.Interactor
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.UserGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.User
import javax.inject.Inject

class SaveUserUseCase
    @Inject constructor(appCoroutineDispatcher: AppCoroutineDispatcher,
                        private var gateway : UserGateway): Interactor<SaveUserUseCase.Response, SaveUserUseCase.Param> (appCoroutineDispatcher){

    override suspend fun start(param: Param): Response {
        gateway.save(param.user)
        return Response()
    }

    data class Param(val user : User)

    class Response
}