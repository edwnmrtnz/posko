package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ProductsServiceEndpoints {

    @GET("/api/v1/products")
    fun getProducts() : Call<MutableList<ProductWithVariantsRaw>>

}