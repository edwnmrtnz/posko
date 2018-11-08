package com.github.posko.pos.gateways.user

import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.database.config.PoskoDatabase
import com.github.posko.core.data.repository.user.UserLocalDataSource
import com.github.posko.core.data.repository.user.UserRemoteDataSource
import com.github.posko.core.data.repository.user.UserRepository
import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.interactor.session.CreateSessionUseCase
import com.github.posko.core.domain.interactor.user.LoginUserUseCase
import com.github.posko.pos.injection.annotations.Local
import com.github.posko.pos.injection.annotations.Remote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepositoryModules {

    @Provides
    @Local
    fun provideLocal(database: PoskoDatabase) : UserGateway {
        return UserLocalDataSource(database.userDao)
    }

    @Provides
    @Remote
    fun provideRemote(services : PoskoServices) : UserGateway {
        return UserRemoteDataSource(services);
    }
    @Provides
    @Singleton
    fun provideRepo(@Local local : UserGateway, @Remote remote : UserGateway) : UserGateway {
        return UserRepository(local, remote)
    }

    @Provides
    fun provideLoginUseCase(dispatcher : AppCoroutineDispatcher, gateway: UserGateway, createSessionUseCase: CreateSessionUseCase) : LoginUserUseCase {
        return LoginUserUseCase(dispatcher, gateway, createSessionUseCase)
    }

}