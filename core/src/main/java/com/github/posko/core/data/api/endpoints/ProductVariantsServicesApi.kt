package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.ProductVariantRaw
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductVariantsServicesApi {

    @GET("/api/v1/products/{product_id}/variants")
    fun getProductVariants(@Path("product_id") product_id : Int) : Deferred<Response<List<ProductVariantRaw>>>

}