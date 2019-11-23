package com.github.posko.feature.checkout

import com.github.posko.toolkit.dagger.scope.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by edwinmartinez on November 23, 2019
 */
@Module
abstract class CheckoutModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeCheckoutFragment() : CheckoutFragment
}