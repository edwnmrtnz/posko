package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.ProductVariantRaw
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProductVariantsServicesApi {

    @GET("/api/v1/products/{product_id}/variants")
    fun getProductVariants(@Path("product_id") product_id : Int) : Deferred<List<ProductVariantRaw>>

    @GET("/api/v1/variants")
    fun getProductVariants(@QueryMap params : HashMap<String, String>) : Deferred<List<ProductVariantRaw>>

}