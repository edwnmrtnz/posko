package com.github.edwnmrtnz.posko.ui.activities.login

import com.github.edwnmrtnz.posko.helper.SessionHelper
import com.github.edwnmrtnz.posko.tools.PoskoLogger

class LoginPresenter(private val view: LoginContract.View, private val sessionHelper: SessionHelper) : LoginContract.Presenter {

    override fun isLoggedIn() {
        if(sessionHelper.isLoggedIn())
            view.showMainActivity()
    }

    override fun authenticate(accountName: String, email: String, password: String) {

        validateCredentials(accountName, email, password)

        PoskoLogger.log("Message after validateCredentials")
    }

    private fun validateCredentials(accountName: String, email: String, password: String) {
        if(accountName.isEmpty()){
            view.showAccountIdError("Cannot be empty")
            return
        }
        if(email.isEmpty()){
            view.showEmailAddressError("Cannot be empty")
            return
        }
        if(password.isEmpty()){
            view.showEmailAddressError("Cannot be empty")
            return
        }
    }

}