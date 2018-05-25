package com.github.edwnmrtnz.posko.ui.activities.login

import android.os.Bundle
import com.github.edwnmrtnz.posko.ui.BaseActivity
import com.github.edwnmrtnz.posko.R
import com.github.edwnmrtnz.poskocore.SessionHelper
import com.github.edwnmrtnz.posko.data.model.User
import com.github.edwnmrtnz.posko.data.repository.user.UserDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserLocalDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRemoteDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRepository
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper
import com.google.gson.GsonBuilder

class LoginActivity : BaseActivity() {

    private lateinit var sessionHelper : SessionHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionHelper = SessionHelper(UserRepository(UserLocalDataSource(), UserRemoteDataSource(RetrofitHelper.getInstance(), GsonBuilder().setPrettyPrinting())))

        log("logging in...")
        sessionHelper.authenticateUser("first_company",
                "admin@first_company.com",
                "pass", object : UserDataSource.AuthenticateUserCallback {
            override fun onAuthenticated(user: User) {
                log("login success!" + "->" + user.toString())
            }

            override fun onFailed(message: String, statusCode: Int) {
                log("login failed")
                log(message)
            }
        })
    }
}
