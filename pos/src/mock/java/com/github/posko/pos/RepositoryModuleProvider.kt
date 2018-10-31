package com.github.posko.pos

import com.github.posko.core.data.repository.user.UserRepository
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.pos.gateways.UserRepositoryModules
import dagger.Module
import dagger.Provides

@Module (includes = arrayOf(
        UserRepositoryModules::class
))
class RepositoryModuleProvider