package com.github.posko.core.data.repository.productvariant

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.database.dao.ProductVariantDao
import com.github.posko.core.data.extension.toDatabase
import com.github.posko.core.domain.gateways.ProductVariantGateway
import com.github.posko.core.domain.model.ProductVariant

class ProductVariantRepository(private var dao : ProductVariantDao) : ProductVariantGateway {
    override suspend fun save(variants: MutableList<ProductVariant>) {
        variants.forEach {
            dao.insert(it.toDatabase())
        }
    }

    override suspend fun save(variant: ProductVariant) {
        dao.insert(variant.toDatabase())
    }
}