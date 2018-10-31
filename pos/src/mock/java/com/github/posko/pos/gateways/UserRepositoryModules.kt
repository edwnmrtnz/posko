package com.github.posko.pos.gateways

import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.repository.user.UserLocalDataSource
import com.github.posko.core.data.repository.user.UserRemoteDataSource
import com.github.posko.core.data.repository.user.UserRepository
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.pos.injection.annotations.Local
import com.github.posko.pos.injection.annotations.Remote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepositoryModules {

    @Provides
    @Local
    fun provideLocal() : UserGateway {
        return UserLocalDataSource()
    }

    @Provides
    @Remote
    fun provideRemote(services : PoskoServices) : UserGateway {
        return UserRemoteDataSource(services)
    }

    @Provides
    @Singleton
    fun provideRepo(@Local local : UserGateway, @Remote remote : UserGateway) : UserGateway {
        return UserRepository(local, remote)
    }
}