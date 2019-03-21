package com.github.posko.core.domain.interactor.user

import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                          private var gateway : UserGateway): UseCase<SaveUserUseCase.Response, SaveUserUseCase.Param> (appCoroutineDispatcher){

    override suspend fun start(param: Param): Response {
        gateway.save(param.user)
        return Response()
    }

    data class Param(val user : User)

    class Response
}