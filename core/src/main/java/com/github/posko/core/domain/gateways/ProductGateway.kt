package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Count
import com.github.posko.core.domain.model.Product
import com.github.posko.core.domain.model.ProductWithVariant

interface ProductGateway {

    suspend fun fetch(params : HashMap<String, String>) : MutableList<ProductWithVariant>

    suspend fun fetchCount(params : HashMap<String, String>) : Count

    suspend fun save(products : MutableList<Product>)

    suspend fun getLastRecordId() : Int?

}