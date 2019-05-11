package com.github.posko.core.domain.interactor.bridge

import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.forms.InvoiceLineForm
import com.github.posko.core.domain.interactor.invoice.SendInvoiceUseCase
import com.github.posko.core.domain.interactor.ticket.GetTicketWithLinesUseCase
import com.github.posko.core.domain.model.Invoice
import com.github.posko.base.dispatcher.AppCoroutineDispatcher
import com.github.posko.base.interactor.UseCase
import javax.inject.Inject

class CreateAndSendInvoiceUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                      private var sendInvoiceUseCase: SendInvoiceUseCase,
                                                      private var getTicketWithLinesUseCase: GetTicketWithLinesUseCase): UseCase<CreateAndSendInvoiceUseCase.Response, CreateAndSendInvoiceUseCase.Param> (appCoroutineDispatcher){

    override suspend fun start(param: Param): Response {
        val ticketWithLines = getTicketWithLinesUseCase.execute(GetTicketWithLinesUseCase.Param(param.ticketNumber)).ticketsWithLine

        val invoiceLineForms : MutableList<InvoiceLineForm> = mutableListOf()

        for(ticketLine in ticketWithLines.ticketLines) {
            invoiceLineForms.add(
                    InvoiceLineForm(
                            ticketLine.variantId,
                            ticketLine.productId,
                            ticketLine.price,
                            ticketLine.title,
                            ticketLine.quantity
                    )
            )
        }

        val invoiceForm = InvoiceForm(ticketWithLines.ticket.ticketNumber, invoiceLineForms)

        val invoice = sendInvoiceUseCase.execute(SendInvoiceUseCase.Param(invoiceForm)).invoice

        return Response(invoice)
    }

    data class Response(val invoice : Invoice)

    data class Param(val ticketNumber : Int)
}