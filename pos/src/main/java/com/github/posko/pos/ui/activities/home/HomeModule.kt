package com.github.posko.pos.ui.activities.home

import com.github.posko.pos.injection.annotations.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun homeFragment() : HomeFragment
}