package com.github.edwnmrtnz.posko.ui.activities.login


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.github.edwnmrtnz.posko.R
import com.github.edwnmrtnz.posko.injection.Injection
class LoginFragment : Fragment(), LoginContract.View {


    //Presenter
    private lateinit var presenter : LoginContract.Presenter

    //Views
    private lateinit var btnLogin : Button
    private lateinit var etAccountId : EditText
    private lateinit var etEmailAddress : EditText
    private lateinit var etPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = LoginPresenter(this, Injection.provideSessionHelper(context!!))

    }

    override fun onResume() {
        super.onResume()

        presenter.isLoggedIn()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        btnLogin        = view.findViewById(R.id.btnLogin)
        etAccountId     = view.findViewById(R.id.etAccountId)
        etEmailAddress  = view.findViewById(R.id.etEmailAddress)
        etPassword      = view.findViewById(R.id.etPassword)

        btnLogin.setOnClickListener {

            val accountId : String = getAccountId()
            val emailaddress : String = getEmailAddress()
            val password : String = getPassword()

            presenter.authenticate(accountId, emailaddress, password)
        }

        return view
    }

    private fun getPassword(): String {
        return etPassword.text.toString()
    }

    private fun getEmailAddress(): String {
        return etEmailAddress.text.toString()
    }

    private fun getAccountId(): String {
        return etAccountId.text.toString()
    }

    override fun showAuthenticatingIndicator() {

    }

    override fun showLoginFailed() {

    }

    override fun showMainActivity() {

    }

    override fun showAccountIdError(message: String) {
    }

    override fun showEmailAddressError(message: String) {
    }

    override fun showPasswordError(message: String) {
    }

}
