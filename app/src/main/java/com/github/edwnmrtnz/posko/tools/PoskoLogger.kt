package com.github.edwnmrtnz.posko.tools

import android.util.Log

class PoskoLogger {

    companion object {
        val TAG = "PoskoLogger"

        @JvmStatic
        fun log(message : String){

            Log.d(TAG, message)
        }

        @JvmStatic
        fun log(TAG : String, message: String){

            log(message)

            Log.d(TAG, message)
        }
    }
}