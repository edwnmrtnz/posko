package com.github.posko.pos.ui.activities.login

import javax.inject.Inject

class LoginPresenter @Inject constructor (): LoginContract.Presenter {

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

    }

}