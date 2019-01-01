package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.ProductVariant
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure

interface ProductVariantsGateway {

    suspend fun getVariants(limit: Long, offset: Long) : Either<Failure,MutableList<ProductVariant>>

    suspend fun fetchVariants(queryParams : HashMap<String, String>) : Either<Failure,MutableList<ProductVariant>>

    suspend fun countVariants(queryParams: HashMap<String, String>) : Either<Failure, Int>
}