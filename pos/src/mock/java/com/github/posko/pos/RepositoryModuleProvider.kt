package com.github.posko.pos

import com.github.posko.pos.gateways.user.UserRepositoryModules
import com.github.posko.pos.gateways.variants.ProductVariantsModule
import dagger.Module

@Module (includes = arrayOf(
        UserRepositoryModules::class,
        ProductVariantsModule::class
))
class RepositoryModuleProvider