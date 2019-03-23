package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.model.Invoice

interface InvoiceGateway {

    suspend fun sendInvoice(invoice : InvoiceForm) : Invoice

    suspend fun saveInvoice(invoice : Invoice)
}