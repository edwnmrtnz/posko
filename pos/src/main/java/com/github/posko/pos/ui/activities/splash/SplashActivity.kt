package com.github.posko.pos.ui.activities.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.posko.pos.ui.activities.login.LoginActivity
import android.content.Intent
import com.github.posko.pos.R


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    finish()
                }
            }
        }
        timer.start()
    }
}
