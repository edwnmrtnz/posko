package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.api.model.ProductVariantRaw
import com.github.posko.core.data.api.model.UserRaw
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response

interface PoskoServices {

    fun login(account_name : String, email : String, password : String) : Deferred<Response<UserRaw>>

    fun getProducts() : Deferred<Response<List<ProductRaw>>>

    fun getProductVariants(product_id : Int) : Deferred<Response<List<ProductVariantRaw>>>
}