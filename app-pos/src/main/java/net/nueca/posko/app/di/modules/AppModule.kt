package net.nueca.posko.app.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by edwinmartinez on June 20, 2019
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(app : Application) : Context {
        return app
    }

}