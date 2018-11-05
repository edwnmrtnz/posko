package com.github.posko.core.domain.interactor.session

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.interactor.CompletableInteractor
import com.github.posko.core.domain.model.Session
import kotlinx.coroutines.experimental.launch

class CheckSessionUseCase(val dispatcher: AppCoroutineDispatcher,
                          val gateway: SessionGateway) : CompletableInteractor<CheckSessionUseCase.Param>(dispatcher) {

    override suspend fun run(params: Param) {
        gateway.checkSession(object : SessionGateway.CheckSessionCallback {
            override fun hasValidSession(session: Session) {
                launch(dispatcher.ui()){
                    params.callback.hasValidSession(session)
                }
            }

            override fun noSessionFound() {
                launch(dispatcher.ui()) {
                    params.callback.noSessionFound()
                }
            }
        })
    }

    data class Param(val callback : SessionGateway.CheckSessionCallback)
}