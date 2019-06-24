package net.nueca.posko.app.features.splash

import com.github.posko.feature.splash.SplashFragment
import com.github.posko.toolkit.dagger.scope.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by edwinmartinez on June 23, 2019
 */

@Module
abstract class SplashModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun bindSplashFragment() : SplashFragment
}