package com.github.posko.session.data.repository.session.remote

import com.github.posko.base.exception.HttpErrorException
import com.github.posko.base.exception.ServiceFailureException
import com.github.posko.restclient.RestClient
import com.github.posko.session.data.api.deserializer.UserDeserializer
import com.github.posko.session.data.api.endpoint.SessionServicesEndpoint
import com.github.posko.session.data.api.model.UserRaw
import com.github.posko.session.data.extension.toDomain
import com.github.posko.session.domain.model.UserCookie
import com.google.gson.GsonBuilder
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalStateException
import java.lang.NullPointerException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SessionRemoteServicesProvider(private val client : RestClient.Builder) : SessionRemoteServices {

    override suspend fun signIn(domain : String, accountName: String, email: String, password: String): UserCookie {
        val gson = GsonBuilder()
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()

        return suspendCancellableCoroutine {
            client.setTag("sign_in")
                    .setBaseUrl(domain)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .createService(SessionServicesEndpoint::class.java)
                    .signIn(accountName, email, password)
                    .enqueue(object : Callback<UserRaw> {
                        override fun onFailure(call: Call<UserRaw>, t: Throwable) {
                            it.resumeWithException(ServiceFailureException(t.message!!, t))
                        }

                        override fun onResponse(call: Call<UserRaw>, response: Response<UserRaw>) {
                            if(response.isSuccessful) {
                                val cookie = response.headers().get("Set-Cookie")
                                if(cookie.isNullOrEmpty()) throw IllegalStateException("No Cookie found!")
                                else {
                                    val userCookie = UserCookie(response.body()!!.toDomain(), cookie)
                                    it.resume(userCookie)
                                }
                            } else {
                                it.resumeWithException(HttpErrorException(response.code(), response.errorBody()?.string() ?: response.message()))
                                System.out.println(response.message())
                            }
                        }
                    })
        }
    }

    override suspend fun signOut() {
        return suspendCancellableCoroutine {
            client.setTag("sign_out")
                    .build()
                    .createService(SessionServicesEndpoint::class.java)
                    .signOut()
                    .enqueue(object : Callback<String> {
                        override fun onFailure(call: Call<String>, t: Throwable) {
                            it.resumeWithException(ServiceFailureException(t.message!!, t))
                        }

                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if(response.isSuccessful) {
                                it.resume(Unit)
                            }  else {
                                it.resumeWithException(HttpErrorException(response.code(), response.errorBody()?.string() ?: response.message()))
                                System.out.println(response.message())
                            }
                        }
                    })
        }
    }
}