package com.github.posko.pos

import com.github.posko.core.data.api.config.ServiceConfigProvider
import com.github.posko.core.data.api.config.ServiceConfiguration
import dagger.Module
import dagger.Provides

@Module
class ServiceConfigurationModule {

    @Provides
    fun provideWebServiceConfiguration() : ServiceConfiguration {
        return ServiceConfigProvider(
                ServiceConfigProvider.EncryptorImpl(),
                ServiceConfigProvider.ServiceLoggerImpl()
        )
    }
}