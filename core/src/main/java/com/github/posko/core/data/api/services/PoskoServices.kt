package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.model.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Path

interface PoskoServices {

    fun login(account_name : String, email : String, password : String) : Deferred<Response<UserRaw>>

    fun getProducts() : Deferred<Response<List<ProductRaw>>>

    fun getProductVariants(product_id : Int) : Deferred<Response<List<ProductVariantRaw>>>

    fun getProductVariants() : Deferred<Response<List<ProductVariantRaw>>>

    fun getInvoices() : Deferred<Response<List<InvoiceRaw>>>

    fun getInvoiceLines(invoice_id: Int) : Deferred<Response<List<InvoiceLineRaw>>>
}