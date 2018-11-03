package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.InvoiceLineRaw
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InvoiceLinesServicesApi {

    @GET("api/v1/invoices/{invoice_id}/invoice_lines")
    fun getInvoiceLines(@Path("invoice_id") invoice_id: Int) : Deferred<List<InvoiceLineRaw>>
}