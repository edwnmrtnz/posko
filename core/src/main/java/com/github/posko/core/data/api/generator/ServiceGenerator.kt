package com.github.posko.core.data.api.generator

import com.github.posko.core.data.api.generator.interceptor.BasicAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class ServiceGenerator private constructor(private var baseUrl: String,
                       private var enableLogging: Boolean,
                       private var loggingTag: String,
                       private var loggingLevel: HttpLoggingInterceptor.Level,
                       private var basicAuth: String,
                       private var converterFactories: MutableList<Converter.Factory>,
                       private var callAdapterFactories: MutableList<CallAdapter.Factory>,
                       private var logger: ServiceLogger) {

    fun <S> generateService(serviceClass : Class<S> ) : S {
        val httpClient = OkHttpClient.Builder()

        if(!basicAuth.isEmpty()) httpClient.addInterceptor(BasicAuthInterceptor(basicAuth))

        if(enableLogging) {
            val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> logger.log(loggingTag, message)
            })
            httpLoggingInterceptor.level = loggingLevel
            httpClient.interceptors().add(httpLoggingInterceptor)
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


    class Builder (private val encryptor: Encryptor, private val logger: ServiceLogger) {

        private lateinit var baseUrl : String

        private var enableLogging = false
        private var loggingTag = "ServiceGenerator"
        private var loggingLevel  = HttpLoggingInterceptor.Level.BODY

        private var basicAuth = ""

        private var converterFactories : MutableList<Converter.Factory> = mutableListOf()

        private var callAdapterFactories : MutableList<CallAdapter.Factory> = mutableListOf()

        fun setBaseUrl(baseUrl : String) : Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun setEnableLogging(tag : String) : Builder {
            this.enableLogging = true
            this.loggingTag = tag
            return this
        }

        fun setEnableLogging(tag: String, loggingLevel: HttpLoggingInterceptor.Level) : Builder {
            this.enableLogging = true
            this.loggingTag = tag
            this.loggingLevel = loggingLevel
            return this
        }

        fun setBasicAuth(username : String, password : String) : Builder {
            this.basicAuth = encryptor.basicAuthentication(username, password)
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

        fun build() : ServiceGenerator {
            return ServiceGenerator(
                    baseUrl,
                    enableLogging,
                    loggingTag,
                    loggingLevel,
                    basicAuth,
                    converterFactories,
                    callAdapterFactories,
                    logger
            )
        }
    }
}