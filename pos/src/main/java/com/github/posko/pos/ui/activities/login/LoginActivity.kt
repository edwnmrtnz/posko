package com.github.posko.pos.ui.activities.login

import android.os.Bundle
import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.BaseActivity
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    @Inject
    lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        isDebug()

        loadFragment()
    }

    private fun loadFragment() {
        var fragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
        if(fragment == null) {
            fragment = loginFragment
            replaceFragmentInActivity(supportFragmentManager, fragment, R.id.contentFrame)
        }
    }
}
