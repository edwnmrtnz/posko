package net.nueca.posko.app.features.login

import com.github.posko.feature.login.LoginFragment
import com.github.posko.toolkit.dagger.scope.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by edwinmartinez on July 07, 2019
 */
@Module
abstract class LoginModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeLoginFragment() : LoginFragment
}