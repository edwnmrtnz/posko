package com.github.posko.feature.splash

import android.os.Bundle
import com.github.posko.feature.base.BaseActivity
import com.github.posko.feature.base.replace

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        replace(R.id.container, SplashFragment())

    }
}
