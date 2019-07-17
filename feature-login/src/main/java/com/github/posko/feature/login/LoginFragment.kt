package com.github.posko.feature.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.github.posko.feature.base.BaseFragment
import com.github.posko.gateway.services.AuthenticationService
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.etAccountId
import javax.inject.Inject


class LoginFragment : BaseFragment() {

    @Inject lateinit var authenticationService: AuthenticationService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.scrollView.requestFocus()

        view.btnSignIn.setOnClickListener {
            validate(view)
        }
    }

    private fun validate(view: View) {
        val accountId = view.etAccountId.text?.trim()
        val email = view.etEmailAddress.text?.trim()
        val password = view.etPassword.text?.trim()

        var hasError = false
        if(accountId.isNullOrEmpty()) {
            setError("Account Id can't be empty",
                view.tvAccountIdLabel,
                view.etAccountId,
                view.tilAccountId)
            hasError = true
        }

        if(email.isNullOrEmpty()){
            setError("Email Address can't be empty",
                view.tvEmailAddressLabel,
                view.etEmailAddress,
                view.tilEmailAddress)
            hasError = true
        }

        if(password.isNullOrEmpty()) {
            setError("Password can't be empty",
                view.tvPasswordLabel,
                view.etPassword,
                view.tilPassword)
            hasError = true
        }

    }

    private fun setError(errorMessage : String,
                         tvLabel : TextView,
                         etTextField : EditText,
                         tilContainer : TextInputLayout) {
        tilContainer.error = errorMessage
        tvLabel.setTextColor(Color.RED)
        etTextField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(tilContainer.isErrorEnabled) {
                    tilContainer.isErrorEnabled = false
                    tilContainer.error = ""
                    tvLabel.setTextColor(resources.getColor(R.color.field_color))
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Ignore
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Ignore
            }
        })
    }
}
