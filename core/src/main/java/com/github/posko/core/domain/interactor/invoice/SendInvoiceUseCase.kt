package com.github.posko.core.domain.interactor.invoice

import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.gateways.InvoiceGateway
import com.github.posko.core.domain.model.Invoice
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class SendInvoiceUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                             private var gateway : InvoiceGateway) : UseCase<SendInvoiceUseCase.Response, SendInvoiceUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        val invoice = gateway.sendInvoice(param.invoice)
        return Response(invoice)
    }

    data class Param(val invoice : InvoiceForm)

    data class Response(val invoice : Invoice)
}
