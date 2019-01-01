package com.github.posko.pos

import com.github.posko.pos.gateways.session.SessionRepositoryModule
import com.github.posko.pos.gateways.user.UserRepositoryModules
import dagger.Module

@Module (includes = arrayOf(
        UserRepositoryModules::class,
        SessionRepositoryModule::class
))
class RepositoryModuleProvider