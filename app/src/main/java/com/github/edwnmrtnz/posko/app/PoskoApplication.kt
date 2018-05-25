package com.github.edwnmrtnz.posko.app

import android.app.Application
import com.github.edwnmrtnz.posko.BuildConfig
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper

class PoskoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitHelper.newInstance().enableLogging(BuildConfig.DEBUG)
    }
}