package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.ProductVariant

interface ProductVariantGateway {

    suspend fun save(variants: MutableList<ProductVariant>)

    suspend fun save(variant : ProductVariant)
}