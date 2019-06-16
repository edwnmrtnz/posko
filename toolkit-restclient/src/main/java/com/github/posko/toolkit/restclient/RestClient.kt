package com.github.posko.toolkit.restclient

import com.github.posko.toolkit.restclient.interceptor.BasicAuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RestClient private constructor (
        private val baseUrl: String,
        private val enableLogging: Boolean,
        private val loggingTag: String,
        private val loggingLevel: HttpLoggingInterceptor.Level,
        private val basicAuth: String?,
        private val converterFactories: MutableList<Converter.Factory>,
        private val callAdapterFactories: MutableList<CallAdapter.Factory>,
        private val logger: ServiceLogger?,
        private val timeOutUnit: TimeUnit?,
        private val timeoutValue: Long,
        private val interceptors : MutableCollection<Interceptor>
) {

    fun <S> createService(serviceClass : Class<S> ) : S {
        val httpClient = OkHttpClient.Builder()

        if(!basicAuth.isNullOrEmpty()) httpClient.addInterceptor(BasicAuthInterceptor(basicAuth))

        if(enableLogging) {
            val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> logger?.log(loggingTag, message)
            })
            httpLoggingInterceptor.level = loggingLevel
            httpClient.interceptors().add(httpLoggingInterceptor)
        }

        if(timeOutUnit != null && timeoutValue > 0) {
            httpClient.connectTimeout(timeoutValue, timeOutUnit)
                    .readTimeout(timeoutValue, timeOutUnit)
                    .writeTimeout(timeoutValue, timeOutUnit)
        }

        interceptors.forEach {
            httpClient.interceptors().add(it)
        }

        val client = httpClient.build()

        val builder = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())

        converterFactories.forEach { builder.addConverterFactory(it) }
        callAdapterFactories.forEach { builder.addCallAdapterFactory(it) }

        return builder.build().create(serviceClass)
    }

    data class Builder (
            private var baseUrl : String = "",
            private var enableLogging : Boolean = false,
            private var loggingTag : String = "ServiceGenerator",
            private var loggingLevel : HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY,
            private var basicAuth  : String? = null,
            private var converterFactories : MutableList<Converter.Factory> = mutableListOf(),
            private var callAdapterFactories : MutableList<CallAdapter.Factory> = mutableListOf(),
            private var timeOutUnit: TimeUnit? = null,
            private var timeoutValue: Long = 0,
            private var serviceLogger: ServiceLogger? = null,
            private var interceptors : MutableList<Interceptor> = mutableListOf()
    ) {
        fun setBaseUrl(baseUrl : String) : Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun setEnableLogging(isEnable : Boolean) : Builder {
            this.enableLogging = isEnable
            return this
        }

        fun setTag(tag: String, loggingLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY) : Builder {
            this.loggingTag     = tag
            this.loggingLevel   = loggingLevel
            return this
        }

        fun setBasicAuth(username : String, password : String) : Builder {
            this.basicAuth = BasicAuthEncryptor.encrypt(username, password)
            return this
        }

        fun addConverterFactory(factory : Converter.Factory) : Builder {
            this.converterFactories.add(factory)
            return this
        }

        fun addCallAdapterFactory(callAdapterFactory : CallAdapter.Factory) : Builder {
            this.callAdapterFactories.add(callAdapterFactory)
            return this
        }

        fun setTimeOut(timeUnit : TimeUnit, value : Long) : Builder {
            this.timeOutUnit = timeUnit
            this.timeoutValue = value
            return this
        }

        fun setLogger(logger : ServiceLogger) : Builder {
            this.serviceLogger = logger
            return this
        }

        fun addInterceptor(interceptor : Interceptor) : Builder {
            interceptors.add(interceptor)
            return this
        }

        fun build() : RestClient {
            return RestClient(
                    baseUrl,
                    enableLogging,
                    loggingTag,
                    loggingLevel,
                    basicAuth,
                    converterFactories,
                    callAdapterFactories,
                    serviceLogger,
                    timeOutUnit,
                    timeoutValue,
                    interceptors
            )
        }
    }
}
