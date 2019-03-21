package com.github.posko.core.domain.interactor.productvariant

import com.github.posko.core.domain.gateways.ProductVariantGateway
import com.github.posko.core.domain.model.ProductVariant
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import com.github.posko.shared.interactor.UseCase
import javax.inject.Inject

class SaveProductVariantsUseCase @Inject constructor(private var appCoroutineDispatcher: AppCoroutineDispatcher,
                                                     private var gateway : ProductVariantGateway): UseCase<SaveProductVariantsUseCase.Response, SaveProductVariantsUseCase.Param> (appCoroutineDispatcher){
    override suspend fun start(param: Param): Response {
        gateway.save(param.variants)
        return Response()
    }

    data class Param(val variants : MutableList<ProductVariant>)

    class Response
}