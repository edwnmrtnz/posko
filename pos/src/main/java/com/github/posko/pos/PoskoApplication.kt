package com.github.posko.pos
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class PoskoApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}