package com.github.posko.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.posko.feature.base.replace

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        replace(R.id.container, LoginFragment())

    }
}
