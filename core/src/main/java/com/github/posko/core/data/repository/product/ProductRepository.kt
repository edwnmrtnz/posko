package com.github.posko.core.data.repository.product

import com.github.posko.core.data.api.services.products.ProductServices
import com.github.posko.core.data.database.dao.ProductDao
import com.github.posko.core.data.extension.toDatabase
import com.github.posko.core.data.extension.toDomain
import com.github.posko.core.domain.gateways.ProductGateway
import com.github.posko.core.domain.model.Count
import com.github.posko.core.domain.model.Product
import com.github.posko.core.domain.model.ProductWithVariant
import com.github.posko.shared.exception.DataNotAvailableException

class ProductRepository(private val dao : ProductDao,
                        private val productsServices : ProductServices) : ProductGateway {

    override suspend fun fetch(params: HashMap<String, String>): MutableList<ProductWithVariant> {
        val productsWithVariants = productsServices.fetchProducts(params)
        if(productsWithVariants.isEmpty()) throw DataNotAvailableException("No variants found")
        else return productsWithVariants
                .map { it.toDomain() }.toMutableList()
    }

    override suspend fun save(products: MutableList<Product>) {
        products.forEach {
            dao.insert(it.toDatabase())
        }
    }

    override suspend fun fetchCount(params: HashMap<String, String>): Count {
        return Count(productsServices.fetchCount(params))
    }

    override suspend fun getLastRecordId(): Int? {
        return dao.getLastRecordedId() ?: throw DataNotAvailableException("No last id found")
    }
}