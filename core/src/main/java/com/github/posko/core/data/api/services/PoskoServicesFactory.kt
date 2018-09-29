package com.github.posko.core.data.api.services

import android.util.Base64
import android.util.Log
import com.github.posko.core.data.api.deserializer.user.UserDeserializer
import com.github.posko.core.data.api.endpoints.UserServicesApi
import com.github.posko.core.data.api.generator.Encryptor
import com.github.posko.core.data.api.generator.ServiceGenerator
import com.github.posko.core.data.api.generator.ServiceLogger
import com.github.posko.core.data.api.model.UserRaw
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import retrofit2.converter.gson.GsonConverterFactory

class PoskoServicesFactory(private val domain : String) : PoskoServices {

    private var serviceBuilder =
            ServiceGenerator.Builder(EncryptorImpl(), ServiceLoggerImpl())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .setBaseUrl(domain)

    private var gsonBuilder = GsonBuilder()
            .setPrettyPrinting()

    override fun login(account_name: String, email: String, password: String): Deferred<UserRaw> {
        val gson = gsonBuilder
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()
        return serviceBuilder
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("login")
                .build()
                .generateService(UserServicesApi::class.java)
                .login(account_name, email, password)
    }

    class EncryptorImpl : Encryptor {
        override fun basicAuthentication(username: String, password: String): String {
            val credentials = String.format("%s:%s", username, password)
            return Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        }
    }

    class ServiceLoggerImpl : ServiceLogger {
        override fun log(tag: String, message: String) {
//            Log.e(tag, message)
        }
    }
}