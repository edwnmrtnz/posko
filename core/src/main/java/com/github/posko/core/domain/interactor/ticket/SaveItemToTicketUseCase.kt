package com.github.posko.core.domain.interactor.ticket

import com.github.posko.core.domain.interactor.ticket.ticketline.AddTicketLineToTicketUseCase
import com.github.posko.core.domain.model.TicketLine
import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.UseCase
import javax.inject.Inject


class SaveItemToTicketUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                  private var createTicketUseCase: CreateTicketUseCase,
                                                  private var addTicketLineToTicketUseCase : AddTicketLineToTicketUseCase) : UseCase<SaveItemToTicketUseCase.Response, SaveItemToTicketUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {

        var ticket = createTicketUseCase.execute(CreateTicketUseCase.Param(param.ticketNumber))

        val ticketLine = TicketLine(param.ticketNumber,
                param.variantId,
                param.productId,
                param.price,
                param.title,
                param.quantity)

        addTicketLineToTicketUseCase.execute(AddTicketLineToTicketUseCase.Param(ticketLine))

        return Response()
    }

    data class Param (
            val ticketNumber : Int,
            val productId : Int,
            val variantId : Int,
            val price : Double,
            val title : String,
            val quantity : Int
    )

    class Response
}
