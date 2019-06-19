package net.nueca.posko.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.nueca.posko.app.di.component.DaggerAppComponent

/**
 * Created by edwinmartinez on June 20, 2019
 */
class PoskoApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}