package com.github.posko.pos.gateways.variants

import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.repository.variants.ProductVariantsLocalDataSource
import com.github.posko.core.data.repository.variants.ProductVariantsRemoteDataSource
import com.github.posko.core.data.repository.variants.ProductVariantsRepository
import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.ProductVariantsGateway
import com.github.posko.core.domain.interactor.variant.FetchVariantsUseCase
import com.github.posko.pos.injection.annotations.Local
import com.github.posko.pos.injection.annotations.Remote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProductVariantsModule {

    @Provides
    @Local
    fun provideLocal() : ProductVariantsGateway {
        return ProductVariantsLocalDataSource()
    }

    @Provides
    @Remote
    fun provideRemote(services : PoskoServices) : ProductVariantsGateway {
        return ProductVariantsRemoteDataSource(services)
    }

    @Provides
    @Singleton
    fun provideRepo(@Local local : ProductVariantsGateway, @Remote remote : ProductVariantsGateway) : ProductVariantsGateway {
        return ProductVariantsRepository(local, remote)
    }

    @Provides
    fun provideFetchVariantsUseCase(dispatcher: AppCoroutineDispatcher, gateway: ProductVariantsGateway) : FetchVariantsUseCase {
        return FetchVariantsUseCase(dispatcher, gateway)
    }

}