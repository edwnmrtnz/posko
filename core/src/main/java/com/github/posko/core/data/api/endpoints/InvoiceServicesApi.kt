package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.InvoiceRaw
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface InvoiceServicesApi {

    @GET("/api/v1/invoices")
    fun getInvoices() : Deferred<List<InvoiceRaw>>

}