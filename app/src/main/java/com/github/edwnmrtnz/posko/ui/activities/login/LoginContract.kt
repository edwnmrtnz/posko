package com.github.edwnmrtnz.posko.ui.activities.login

interface LoginContract {

    interface View {

        fun showAuthenticatingIndicator()

        fun showLoginFailed ()

        fun showMainActivity()

        fun showAccountIdError(message : String)

        fun showEmailAddressError(message : String)

        fun showPasswordError(message : String)

    }

    interface Presenter {

        fun isLoggedIn()

        fun authenticate(accountName : String, email : String, password : String)
    }
}