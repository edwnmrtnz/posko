package com.github.posko.pos.ui.activities.login


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.home.HomeActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment @Inject constructor(): DaggerFragment (), LoginContract.View {

    private lateinit var btnLogin : AppCompatButton
    private lateinit var etAccountName : AppCompatEditText
    private lateinit var etEmailAddress: AppCompatEditText
    private lateinit var etPassword : AppCompatEditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        with(view) {
            btnLogin        = findViewById(R.id.btn_login)
            etAccountName   = findViewById(R.id.et_account_name)
            etEmailAddress  = findViewById(R.id.et_email_address)
            etPassword      = findViewById(R.id.et_password)
        }

        btnLogin.setOnClickListener {
            showHomeActivity()
        }

        return view
    }

    override fun showHomeActivity() {
        startActivity(Intent(context, HomeActivity::class.java))
        (context as Activity).finish()
    }

    override fun showProgress(message: String) {

    }

    override fun hideProgress(message: String) {

    }

    override fun showDialog(message: String) {

    }

    override fun hideDialog(message: String) {

    }

    override fun showAccountNameError(message: String) {

    }

    override fun showEmailError(message: String) {

    }

    override fun showPasswordError(message: String) {

    }

}
