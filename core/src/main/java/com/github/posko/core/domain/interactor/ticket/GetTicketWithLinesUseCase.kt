package com.github.posko.core.domain.interactor.ticket

import com.github.posko.core.domain.gateways.TicketGateway
import com.github.posko.core.domain.model.TicketWithLines
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class GetTicketWithLinesUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                    private var gateway : TicketGateway) :
        UseCase<GetTicketWithLinesUseCase.Response, GetTicketWithLinesUseCase.Param>(appCoroutineDispatcher) {
    override suspend fun start(param: Param): Response {
        return Response(gateway.getTicketWithLines(param.ticketNumber))
    }

    data class Param(var ticketNumber : Int)

    data class Response(var ticketsWithLine : MutableList<TicketWithLines>)

}
