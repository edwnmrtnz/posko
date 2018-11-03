package com.github.posko.pos.ui.activities.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.github.posko.pos.BuildConfig

import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.home.HomeActivity
import com.github.posko.pos.ui.dialog.LoadingProgressDialog
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment @Inject constructor(): DaggerFragment(), LoginContract.View {

    private lateinit var btnLogin : AppCompatButton
    private lateinit var etAccountName : AppCompatEditText
    private lateinit var etEmailAddress: AppCompatEditText
    private lateinit var etPassword : AppCompatEditText

    @Inject lateinit var presenter : LoginPresenter

    private var dialog : LoadingProgressDialog = LoadingProgressDialog()

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

        if(BuildConfig.DEBUG) {
            etAccountName.setText(getString(R.string.login_sample_account_name))
            etEmailAddress.setText(getString(R.string.sample_login_email))
            etPassword.setText(getString(R.string.sample_login_pass))
        }

        presenter.takeView(this)

        return view
    }

    private fun clickHandler() {
        btnLogin.setOnClickListener {
            presenter.onLoginClicked(etAccountName.text.toString(), etEmailAddress.text.toString(), etPassword.text.toString())
        }
    }

    override fun showHomeActivity() {
        val intent = Intent(context,HomeActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }

    override fun showProgress(message: String) {
        dialog.setMessage(message)
        dialog.isCancelable = false
        dialog.show(activity!!.supportFragmentManager, "loading_progress_dialog")
    }

    override fun hideProgress() {
        dialog.dismiss()
    }

    override fun showDialog(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showAccountNameError(message: String) {
        etAccountName.error = message
    }

    override fun showEmailError(message: String) {
        etEmailAddress.error = message
    }

    override fun showPasswordError(message: String) {
        etPassword.error = message
    }

}
