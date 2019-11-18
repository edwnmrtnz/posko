package com.github.posko.feature.login

import com.github.posko.feature.base.BasePresenter
import com.github.posko.feature.base.BaseView
import com.github.posko.domain.services.model.PoskoUser

/**
 * Created by edwinmartinez on July 07, 2019
 */
interface LoginContract {

    interface View : BaseView {

        fun showLoginSuccess(user : PoskoUser)

        fun showInvalidAccountId(message : String)

        fun showInvalidDomain(message : String)

        fun showInvalidEmail(message : String)

        fun showInvalidPassword(password : String)
    }

    interface Presenter : BasePresenter<View> {

        fun authenticate(domain : String, accountId : String, email : String, password : String)
    }

}