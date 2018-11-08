package com.github.posko.pos.ui.activities.splash

import android.os.Bundle
import com.github.posko.pos.ui.activities.login.LoginActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.interactor.session.CheckSessionUseCase
import com.github.posko.core.domain.model.EmptyParam
import com.github.posko.core.domain.model.Session
import com.github.posko.pos.R
import com.github.posko.pos.ui.activities.BaseActivity
import com.github.posko.pos.ui.activities.home.HomeActivity
import javax.inject.Inject


class SplashActivity : BaseActivity(), SessionGateway.CheckSessionCallback {


    @Inject lateinit var checkSessionUseCase: CheckSessionUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkSessionUseCase.execute(CheckSessionUseCase.Param(this))
    }

    override fun hasValidSession(session: Session) {
        startTimer(true)
    }

    override fun noSessionFound() {
        startTimer(false)
    }

    private fun startTimer(hasSession : Boolean) {
        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    if(hasSession) {
                        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
                    } else {
                        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                        finish()
                    }
                }
            }
        }
        timer.start()
    }
}
