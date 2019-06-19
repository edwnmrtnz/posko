package net.nueca.posko.app.di.modules

import com.github.posko.feature.splash.SplashNavigation
import dagger.Module
import dagger.Provides
import net.nueca.posko.app.navigations.SplashNavigationProvider
import javax.inject.Singleton

/**
 * Created by edwinmartinez on June 20, 2019
 */
@Module
class PoskoNavigationModule {

    @Provides
    @Singleton
    fun provideSplashNavigation() : SplashNavigation {
        return SplashNavigationProvider()
    }
}