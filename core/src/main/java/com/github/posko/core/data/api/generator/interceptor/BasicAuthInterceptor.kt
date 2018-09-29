package com.github.posko.core.data.api.generator.interceptor

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(private val basicAuth : String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()

        requestBuilder.header("Authorization", "Basic $basicAuth")

        if (Build.VERSION.SDK_INT < 22 && original.method() == "PATCH")
            requestBuilder.header("X-HTTP-Method-Override", "PATCH")

        requestBuilder.method(original.method(), original.body())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}