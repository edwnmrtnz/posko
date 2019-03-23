package com.github.posko.core.domain.interactor.ticket

import com.github.posko.core.domain.gateways.TicketGateway
import com.github.posko.core.domain.model.Ticket
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class GetTicketUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                           private var ticketGateway: TicketGateway): UseCase<GetTicketUseCase.Response, GetTicketUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        return Response(ticketGateway.get(param.ticketNumber))
    }

    data class Param(val ticketNumber : Int)

    data class Response(val ticket : Ticket)
}