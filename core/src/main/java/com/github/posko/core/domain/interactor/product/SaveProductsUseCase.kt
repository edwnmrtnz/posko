package com.github.posko.core.domain.interactor.product

import com.github.posko.core.domain.gateways.ProductGateway
import com.github.posko.core.domain.model.Product
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class SaveProductsUseCase @Inject constructor
    (private var appCoroutineDispatcher: AppCoroutineDispatcher,
     private var gateway : ProductGateway) : UseCase<SaveProductsUseCase.Response, SaveProductsUseCase.Param>(appCoroutineDispatcher) {

    override suspend fun start(param: Param): Response {
        gateway.save(param.products)
        return Response()
    }

    data class Param(val products : MutableList<Product>)

    class Response
}