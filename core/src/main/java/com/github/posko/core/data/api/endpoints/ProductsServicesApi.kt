package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.ProductRaw
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProductsServicesApi {

    @GET("/api/v1/products")
    fun getProducts() : Deferred<Response<List<ProductRaw>>>

}