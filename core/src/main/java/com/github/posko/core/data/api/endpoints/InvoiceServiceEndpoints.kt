package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.InvoiceRaw
import com.github.posko.core.domain.forms.InvoiceForm
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface InvoiceServiceEndpoints {

    @GET("/api/v1/invoices")
    fun getInvoices() : Call<List<InvoiceRaw>>

    @POST("api/v1/invoices")
    fun createInvoice(@Body invoiceForm : InvoiceForm) : Call<InvoiceRaw>

}