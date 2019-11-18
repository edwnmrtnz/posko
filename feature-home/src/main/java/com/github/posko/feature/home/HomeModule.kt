package com.github.posko.feature.home

import com.github.posko.toolkit.dagger.scope.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by edwinmartinez on November 18, 2019
 */
@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeHomeFragment() : HomeFragment
}