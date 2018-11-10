package com.github.posko.pos.ui.activities.login

import com.github.posko.pos.ui.BasePresenter
import com.github.posko.pos.ui.BaseView

interface LoginContract {

    interface Presenter : BasePresenter<View>  {

        fun onLoginClicked(server : String, account_name : String, email : String, password: String)

    }

    interface View : BaseView {

        fun showHomeActivity()

        fun showAccountNameError(message : String)

        fun showEmailError(message: String)

        fun showPasswordError(message : String)

        fun showDomainError(message : String)
    }
}