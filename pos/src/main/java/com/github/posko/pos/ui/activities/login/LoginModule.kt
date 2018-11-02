package com.github.posko.pos.ui.activities.login

import com.github.posko.pos.injection.annotations.FragmentScoped
import com.github.posko.pos.ui.dialog.LoadingProgressDialog
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun loginFragment() : LoginFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun loadingProgressDialog() : LoadingProgressDialog

}