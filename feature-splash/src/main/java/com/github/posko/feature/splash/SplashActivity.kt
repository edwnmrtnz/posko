package com.github.posko.feature.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(savedInstanceState != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, SplashFragment())
                    .commit()
        }
    }
}
