package net.nueca.posko.app.di.modules

import com.github.posko.feature.login.LoginNavigation
import com.github.posko.feature.splash.SplashNavigation
import dagger.Module
import dagger.Provides
import dagger.Reusable
import net.nueca.posko.app.features.login.LoginNavigationProvider
import net.nueca.posko.app.features.splash.SplashNavigationProvider

/**
 * Created by edwinmartinez on July 07, 2019
 */
@Module
class NavigationModule {

    @Provides
    @Reusable
    fun provideSplashNavigation() : SplashNavigation {
        return SplashNavigationProvider()
    }

    @Provides
    @Reusable
    fun provideLoginNavigation() : LoginNavigation {
        return LoginNavigationProvider()
    }
}