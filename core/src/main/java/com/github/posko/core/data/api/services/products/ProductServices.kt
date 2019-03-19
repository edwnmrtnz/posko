package com.github.posko.core.data.api.services.products

import com.github.posko.core.data.api.model.ProductWithVariantsRaw

interface ProductServices {

    suspend fun fetchProducts(params : HashMap<String, String>) : MutableList<ProductWithVariantsRaw>
}