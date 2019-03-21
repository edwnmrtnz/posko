package com.github.posko.core.domain.interactor.session

import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.model.Session
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class CreateSessionUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                               private var gateway: SessionGateway) : UseCase<CreateSessionUseCase.Response, CreateSessionUseCase.Param> (appCoroutineDispatcher){

    override suspend fun start(param: Param): Response {
        val session =  Session(param.userId, param.domain, param.authToken, param.token)
        gateway.create(session)
        return Response(session)
    }

    data class Param(val userId : Int,
                     val domain : String,
                     val authToken : String,
                     val token : String)

    data class Response(val session : Session)
}