package com.github.posko.core.domain.interactor.ticket

import com.github.posko.core.domain.gateways.TicketGateway
import com.github.posko.core.domain.model.TicketWithLines
import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.UseCase
import javax.inject.Inject

class GetTicketsWithLinesUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                     private var gateway : TicketGateway): UseCase<GetTicketsWithLinesUseCase.Response, Unit> (appCoroutineDispatcher){

    override suspend fun start(param: Unit): Response {
        return Response(gateway.getTicketsWithLines())
    }

    data class Response(val ticketWithLines : MutableList<TicketWithLines>)
}