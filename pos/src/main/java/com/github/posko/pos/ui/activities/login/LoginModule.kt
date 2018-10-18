package com.github.posko.pos.ui.activities.login

import com.github.posko.pos.injection.annotations.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun loginFragment() : LoginFragment
}