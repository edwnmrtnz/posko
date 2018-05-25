package com.github.edwnmrtnz.posko.ui

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.edwnmrtnz.posko.tools.PoskoLogger
import com.github.edwnmrtnz.poskocore.PoskoLogger

abstract class BaseActivity : AppCompatActivity() {
    val TAG = "Logger"

    fun toast(message : String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun log(message : String){
        PoskoLogger.log(message)
    }
}