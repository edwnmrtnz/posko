package com.github.posko.core.data.api.services.login

import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.UserDeserializer
import com.github.posko.core.data.api.endpoints.LoginServicesApi
import com.github.posko.core.data.api.model.UserRaw
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Deferred
import retrofit2.converter.gson.GsonConverterFactory

class LoginServicesProvider(private val config : ServiceConfiguration,
                            private val gson : GsonBuilder) : LoginServices {

    override fun loginUser(domain : String, account_name: String, email: String, password: String): Deferred<UserRaw> {
        val gson = gson
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()
        return config.getConfig()
                .setBaseUrl(domain)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("login")
                .build()
                .generateService(LoginServicesApi::class.java)
                .login(account_name, email, password)
    }
}