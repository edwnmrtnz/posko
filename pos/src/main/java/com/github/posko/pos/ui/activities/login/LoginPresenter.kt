package com.github.posko.pos.ui.activities.login

import com.github.posko.core.domain.interactor.user.LoginUserUseCase
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure
import com.github.posko.pos.BuildConfig
import javax.inject.Inject

class LoginPresenter @Inject constructor (private var loginUserUseCase: LoginUserUseCase): LoginContract.Presenter {

    private lateinit var view : LoginContract.View

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }


    override fun onLoginClicked(server: String, account_name: String, email: String, password: String) {

        if(server.isEmpty()) {
            view.showDomainError("Cannot be empty")
            return
        }

        if(account_name.isEmpty()) {
            view.showAccountNameError("Cannot be empty")
            return
        }

        if(email.isEmpty()) {
            view.showEmailError("Cannot be empty")
            return
        }

        if(password.isEmpty()) {
            view.showPasswordError("Cannot be empty")
            return
        }

        view.showLoading("Authenticating...")
        loginUserUseCase.execute(LoginUserUseCase.Param(server, account_name, email, password)) {
            view.hideLoading()
            if(it.isRight) {
                view.showHomeActivity()
            } else {
                val error = it as Either.Left<Failure>
                val message = error.error.message
                view.showPopup(message)
            }
        }
    }

}