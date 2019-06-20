package com.github.posko.feature.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.posko.toolkit.ui.replace

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        savedInstanceState?.let {
            replace(R.id.container, SplashFragment())
        }
    }
}
