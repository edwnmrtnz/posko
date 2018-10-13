package com.github.posko.core.data.api.services

import android.util.Base64
import com.github.posko.core.data.api.config.ServiceConfiguration
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

class PoskoServicesFactory(private val config: ServiceConfiguration) : PoskoServices {

    private var gsonBuilder = GsonBuilder().setPrettyPrinting()

    override fun login(account_name: String, email: String, password: String): Deferred<UserRaw> {
        val gson = gsonBuilder
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()

        return config
                .getConfig()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("login")
                .build()
                .generateService(UserServicesApi::class.java)
                .login(account_name, email, password)
    }

}