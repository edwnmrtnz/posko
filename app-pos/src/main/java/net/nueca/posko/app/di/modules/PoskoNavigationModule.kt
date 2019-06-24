package net.nueca.posko.app.di.modules

import com.github.posko.feature.splash.SplashNavigation
import dagger.Module
import dagger.Provides
import dagger.Reusable
import net.nueca.posko.app.features.splash.SplashNavigationProvider

/**
 * Created by edwinmartinez on June 23, 2019
 */
@Module
class PoskoNavigationModule {

    @Provides
    @Reusable
    fun provideSplashNavigation() : SplashNavigation {
        return SplashNavigationProvider()
    }

}