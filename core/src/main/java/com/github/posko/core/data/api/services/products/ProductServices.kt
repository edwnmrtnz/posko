package com.github.posko.core.data.api.services.products

import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import com.github.posko.core.domain.model.Count

interface ProductServices {

    suspend fun fetchProducts(params : HashMap<String, String>) : MutableList<ProductWithVariantsRaw>

    suspend fun fetchCount(params : HashMap<String, String>) : Int
}