package com.github.posko.core.data.repository.invoice

import com.github.posko.core.data.api.services.invoice.InvoiceServices
import com.github.posko.core.data.extension.toDomain
import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.gateways.InvoiceGateway
import com.github.posko.core.domain.model.Invoice

class InvoiceRepository(private val services: InvoiceServices) : InvoiceGateway {

    override suspend fun sendInvoice(invoice: InvoiceForm): Invoice {
        return services.createInvoice(invoice).toDomain()
    }

    override suspend fun saveInvoice(invoice: Invoice) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}