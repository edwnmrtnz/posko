package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.model.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Path

interface PoskoServices {

    fun login(domain : String, account_name : String, email : String, password : String) : Deferred<UserRaw>

    fun getProducts() : Deferred<List<ProductRaw>>

    fun getProductVariants(product_id : Int) : Deferred<List<ProductVariantRaw>>

    fun getProductVariants() : Deferred<List<ProductVariantRaw>>

    fun getInvoices() : Deferred<List<InvoiceRaw>>

    fun getInvoiceLines(invoice_id: Int) : Deferred<List<InvoiceLineRaw>>
}