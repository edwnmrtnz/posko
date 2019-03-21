package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.CountRaw
import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductsServiceEndpoints {

    @GET("/api/v1/variants")
    fun getProducts(@QueryMap params : HashMap<String, String>) : Call<MutableList<ProductWithVariantsRaw>>

    @GET("/api/v1/variants/count")
    fun getCount(@QueryMap params : HashMap<String, String>) : Call<CountRaw>
}