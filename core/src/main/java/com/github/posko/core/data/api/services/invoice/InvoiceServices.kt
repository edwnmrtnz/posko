package com.github.posko.core.data.api.services.invoice

import com.github.posko.core.data.api.model.InvoiceRaw
import com.github.posko.core.domain.forms.InvoiceForm

interface InvoiceServices {

    suspend fun createInvoice(invoiceForm : InvoiceForm) : InvoiceRaw

}