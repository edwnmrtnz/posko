package com.github.posko.toolkit.restclient.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(private val basicAuth : String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()

        requestBuilder.header("Authorization", "Basic $basicAuth")
        requestBuilder.method(original.method(), original.body())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}