package com.github.posko.pos.ui.activities.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

import com.github.posko.pos.R
import com.github.posko.pos.ui.dialog.LoadingProgressDialog
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment @Inject constructor(): DaggerFragment(), LoginContract.View {

    private lateinit var btnLogin : AppCompatButton
    private lateinit var etAccountName : AppCompatEditText
    private lateinit var etEmailAddress: AppCompatEditText
    private lateinit var etPassword : AppCompatEditText

    @Inject lateinit var presenter : LoginPresenter

    private lateinit var dialog : LoadingProgressDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        with(view) {
            btnLogin        = findViewById(R.id.btn_login)
            etAccountName   = findViewById(R.id.et_account_name)
            etEmailAddress  = findViewById(R.id.et_email_address)
            etPassword      = findViewById(R.id.et_password)
        }
        clickHandler()

        val dialog = LoadingProgressDialog().setMessage("Hello World")
        dialog.show(activity?.supportFragmentManager, "loading_progress_dialog")

        return view
    }

    private fun clickHandler() {
        btnLogin.setOnClickListener {
            presenter.onLoginClicked(etAccountName.text.toString(), etEmailAddress.text.toString(), etPassword.text.toString())
        }
    }

    override fun showHomeActivity() {

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
