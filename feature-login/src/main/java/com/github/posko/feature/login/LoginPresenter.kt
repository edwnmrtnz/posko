package com.github.posko.feature.login

import javax.inject.Inject

/**
 * Created by edwinmartinez on July 07, 2019
 */
class LoginPresenter @Inject constructor(): LoginContract.Presenter {

    private lateinit var view : LoginContract.View

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }

    override fun authenticate(domain: String, accountId: String, email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}