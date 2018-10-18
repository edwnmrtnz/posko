package com.github.posko.pos.injection.modules

import android.app.Application
import android.content.Context
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
}