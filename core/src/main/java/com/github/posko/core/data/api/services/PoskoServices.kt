package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.model.*
import kotlinx.coroutines.Deferred

interface PoskoServices {

    fun login(domain : String, account_name : String, email : String, password : String) : Deferred<UserRaw>

    fun getProducts() : Deferred<List<ProductRaw>>

    fun getProductVariant(product_id : Int) : Deferred<List<ProductVariantRaw>>

    fun getProductVariants(queryParam : HashMap<String, String>) : Deferred<List<ProductVariantRaw>>

    fun getInvoices() : Deferred<List<InvoiceRaw>>

    fun getInvoiceLines(invoice_id: Int) : Deferred<List<InvoiceLineRaw>>
}