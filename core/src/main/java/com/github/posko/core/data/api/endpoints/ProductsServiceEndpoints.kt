package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.ProductRaw
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ProductsServiceEndpoints {

    @GET("/api/v1/products")
    fun getProducts() : Deferred<List<ProductRaw>>

}