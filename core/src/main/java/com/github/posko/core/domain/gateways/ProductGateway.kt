package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.ProductWithVariant

interface ProductGateway {

    fun fetchProductWithVariants(params : HashMap<String, String>) : MutableList<ProductWithVariant>

}