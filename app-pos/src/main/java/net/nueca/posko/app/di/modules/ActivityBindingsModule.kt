package net.nueca.posko.app.di.modules

import com.github.posko.feature.login.LoginActivity
import com.github.posko.feature.splash.SplashActivity
import com.github.posko.toolkit.dagger.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.nueca.posko.app.features.splash.SplashModule

/**
 * Created by edwinmartinez on June 23, 2019
 */
@Module
abstract class ActivityBindingsModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun contributeSplashActivity() : SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity() : LoginActivity
}