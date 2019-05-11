package com.github.posko.core.domain.interactor.ticket

import com.github.posko.core.domain.model.Ticket
import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.UseCase
import javax.inject.Inject

class CreateTicketUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher): UseCase<CreateTicketUseCase.Response, CreateTicketUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        return Response(Ticket(param.ticketNumber))
    }

    data class Param (val ticketNumber : Int)

    data class Response(val ticket : Ticket)
}