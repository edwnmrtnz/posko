package com.github.posko.core.data.api.services.login

import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.UserDeserializer
import com.github.posko.core.data.api.endpoints.LoginServiceEndpoints
import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.shared.exception.HttpErrorException
import com.google.gson.GsonBuilder
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LoginServicesProvider(private val config : ServiceConfiguration,
                            private val gson : GsonBuilder) : LoginServices {
    override suspend fun login(domain: String, account_name: String, email: String, password: String): UserRaw {
        val gson = gson
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()
        return suspendCancellableCoroutine {
            config.getConfig()
                    .setBaseUrl(domain)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .setEnableLogging("login")
                    .build()
                    .generateService(LoginServiceEndpoints::class.java)
                    .login(account_name, email, password)
                    .enqueue(object : Callback<UserRaw> {
                        override fun onFailure(call: Call<UserRaw>, t: Throwable) {
                            it.resumeWithException(t)
                        }
                        override fun onResponse(call: Call<UserRaw>, response: Response<UserRaw>) {
                            if(response.isSuccessful) {
                                it.resume(response.body()!!)
                            } else {
                                it.resumeWithException(HttpErrorException(response.code(),
                                        response.errorBody()?.string() ?: "Something went wrong"))
                            }
                        }
                    })
        }
    }

}