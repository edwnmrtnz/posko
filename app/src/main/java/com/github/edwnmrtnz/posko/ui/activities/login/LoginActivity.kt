package com.github.edwnmrtnz.posko.ui.activities.login

import android.os.Bundle
import com.github.edwnmrtnz.posko.ui.BaseActivity
import com.github.edwnmrtnz.posko.R
import com.github.edwnmrtnz.posko.data.model.User
import com.github.edwnmrtnz.posko.data.repository.user.UserDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserLocalDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRemoteDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRepository
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper
import com.github.edwnmrtnz.posko.helper.SessionHelper
import com.google.gson.GsonBuilder

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
