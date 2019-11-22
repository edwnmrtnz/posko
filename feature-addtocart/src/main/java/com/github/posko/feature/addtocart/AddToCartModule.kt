package com.github.posko.feature.addtocart

import com.github.posko.toolkit.dagger.scope.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by edwinmartinez on November 22, 2019
 */

@Module
abstract class AddToCartModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeAddToCartFragment() : AddToCartFragment
}