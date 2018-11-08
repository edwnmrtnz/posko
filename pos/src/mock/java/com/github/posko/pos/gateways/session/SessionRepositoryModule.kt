package com.github.posko.pos.gateways.session

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.database.config.PoskoDatabase
import com.github.posko.core.data.helper.SessionHelper
import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.interactor.session.CheckSessionUseCase
import com.github.posko.core.domain.interactor.session.CreateSessionUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SessionRepositoryModule {

    @Provides
    fun provideSessionGateway(database : PoskoDatabase) : SessionGateway {
        return SessionHelper(database.sessionDao)
    }

    @Provides
    fun provideRequestAuthorization(database: PoskoDatabase) : RequestAuthorization {
        return SessionHelper(database.sessionDao)
    }

    @Provides
    fun provideCreateSessionUseCase(dispatcher: AppCoroutineDispatcher,
                                    gateway: SessionGateway) : CreateSessionUseCase {
        return CreateSessionUseCase(dispatcher, gateway)
    }

    @Provides
    fun provideCheckSessionUseCase(dispatcher: AppCoroutineDispatcher,
                                   gateway: SessionGateway) : CheckSessionUseCase{
        return CheckSessionUseCase(dispatcher, gateway)
    }
}
