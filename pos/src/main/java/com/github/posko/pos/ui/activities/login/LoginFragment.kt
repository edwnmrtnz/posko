package com.github.posko.pos.ui.activities.login


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.home.HomeActivity

class LoginFragment : Fragment(), LoginContract.View {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
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
