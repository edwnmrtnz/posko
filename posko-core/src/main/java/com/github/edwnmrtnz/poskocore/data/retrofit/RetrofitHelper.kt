package com.github.edwnmrtnz.poskocore.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitHelper {

    companion object {
        @JvmStatic
        var INSTANCE : RetrofitHelper? = null

        @JvmStatic
        fun newInstance() : RetrofitHelper{
            if(INSTANCE == null){
                INSTANCE = RetrofitHelper()
            }
            return INSTANCE as RetrofitHelper
        }

        @JvmStatic
        fun getInstance() : RetrofitHelper {
            if(INSTANCE == null) throw NullPointerException("Please call RetrofitClient.newInstance()")
            else return INSTANCE as RetrofitHelper
        }

        @JvmStatic
        fun destroyInstance() {
            if(INSTANCE != null) INSTANCE = null
        }


    }

    private var enableLogging : Boolean = false

    fun enableLogging(value : Boolean){
        this.enableLogging = value
    }

    fun <S> createService(BASE_URL: String, basicAuth: String?, serviceClass: Class<S>, factory: Converter.Factory): S {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)

        val httpclient = OkHttpClient.Builder()
        if (basicAuth != null) {

            httpclient.addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder().header("Authorization", basicAuth)
                requestBuilder.header("Accept", "application/json")
                requestBuilder.method(original.method(), original.body())

                val request = requestBuilder.build()
                chain.proceed(request)
            }
        }

        if(enableLogging) httpclient.interceptors().add(interceptor)

        val client = httpclient.build()
        builder.client(client)

        return builder.build().create(serviceClass)
    }

}