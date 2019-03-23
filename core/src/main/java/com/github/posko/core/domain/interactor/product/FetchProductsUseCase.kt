package com.github.posko.core.domain.interactor.product

import com.github.posko.core.domain.gateways.ProductGateway
import com.github.posko.core.domain.interactor.product.variant.SaveProductVariantsUseCase
import com.github.posko.core.domain.model.Product
import com.github.posko.core.domain.model.ProductVariant
import com.github.posko.shared.RequestParameter
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.exception.DataNotAvailableException
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class FetchProductsUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                               private var gateway: ProductGateway,
                                               private var saveProductsUseCase: SaveProductsUseCase,
                                               private var saveProductVariantsUseCase: SaveProductVariantsUseCase): UseCase<FetchProductsUseCase.Response, Unit>(appCoroutineDispatcher){

    override suspend fun start(param: Unit): Response {
        val lastId = try {
            gateway.getLastRecordId()
        } catch (e : DataNotAvailableException) {
            null
        }
        val params = RequestParameter.Builder()
                .limit(100)
        if(lastId != null) params.sinceId(lastId)
        else params.activeOnly()

        val data = gateway.fetch(params.build().params)

        val products : MutableList<Product> = mutableListOf()
        val variants : MutableList<ProductVariant> = mutableListOf();
        for(productWithVariant in data) {
            products.add(productWithVariant.product)
            variants.addAll(productWithVariant.variants)
        }
        saveProductsUseCase.execute(SaveProductsUseCase.Param(products))
        saveProductVariantsUseCase.execute(SaveProductVariantsUseCase.Param(variants))
        return Response(products)
    }

    data class Response (val products : MutableList<Product>)

}