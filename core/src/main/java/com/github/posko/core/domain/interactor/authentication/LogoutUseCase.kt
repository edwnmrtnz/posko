package com.github.posko.core.domain.interactor.authentication

import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private var appCoroutineDispatchers: AppCoroutineDispatcher): UseCase<LogoutUseCase.Response, Unit>(appCoroutineDispatchers) {
    override suspend fun start(param: Unit): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class Response
}