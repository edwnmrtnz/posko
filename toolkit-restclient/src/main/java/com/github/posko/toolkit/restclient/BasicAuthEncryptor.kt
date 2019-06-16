package com.github.posko.toolkit.restclient

import android.util.Base64

class BasicAuthEncryptor {
    companion object {
        @JvmStatic
        fun encrypt(userName : String, password : String) : String {
            val creds = String.format("%s:%s", userName, password)
            return Base64.encodeToString(creds.toByteArray(), Base64.NO_WRAP)
        }
    }
}