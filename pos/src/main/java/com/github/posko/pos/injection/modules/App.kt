package com.github.posko.pos.injection.modules

import android.app.Application
import android.content.Context
import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.api.services.PoskoServicesFactory
import com.github.posko.core.data.database.config.PoskoDatabase
import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.dispatcher.CoroutineDispatcherProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class App {

    @Provides
    @Singleton
    fun provideAppContext(app : Application) : Context {
        return app
    }

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder().setPrettyPrinting().create()
    }

    @Provides
    @Singleton
    fun providePoskoServices(config : ServiceConfiguration, authorization: RequestAuthorization) : PoskoServices {
        return PoskoServicesFactory(config, authorization)
    }

    @Provides
    @Singleton
    fun provideCoroutineDispatcher() : AppCoroutineDispatcher {
        return CoroutineDispatcherProvider()
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : PoskoDatabase {
        return PoskoDatabase.getInstance(context)!!
    }
}