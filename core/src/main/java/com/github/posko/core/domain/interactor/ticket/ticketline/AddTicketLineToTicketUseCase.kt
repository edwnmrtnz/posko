package com.github.posko.core.domain.interactor.ticket.ticketline

import com.github.posko.core.domain.exception.TicketDoesNotExistException
import com.github.posko.core.domain.gateways.TicketLineGateway
import com.github.posko.core.domain.interactor.ticket.GetTicketUseCase
import com.github.posko.core.domain.model.Ticket
import com.github.posko.core.domain.model.TicketLine
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.exception.DataNotAvailableException
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class AddTicketLineToTicketUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                       private var getTicketUseCase: GetTicketUseCase,
                                                       private var gateway : TicketLineGateway): UseCase<AddTicketLineToTicketUseCase.Response, AddTicketLineToTicketUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        try {
            getTicketUseCase.execute(GetTicketUseCase.Param(param.ticketLine.ticketNumber))
        } catch (e: DataNotAvailableException) {
            null
        } ?: throw TicketDoesNotExistException("Please call SaveItemToTicketUseCase")

        gateway.save(param.ticketLine)
        return Response()
    }

    data class Param(val ticketLine : TicketLine)

    class Response
}