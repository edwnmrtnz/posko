package com.github.posko.pos.ui.activities.login

import com.github.posko.core.domain.interactor.user.LoginUserUseCase
import javax.inject.Inject

class LoginPresenter @Inject constructor (private var loginUserUseCase: LoginUserUseCase): LoginContract.Presenter {

    override fun checkSession() {

    }

    override fun onLoginClicked(account_name: String, email: String, password: String) {

    }
}