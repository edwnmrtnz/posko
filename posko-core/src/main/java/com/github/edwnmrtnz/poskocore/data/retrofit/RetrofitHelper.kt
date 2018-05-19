package com.github.edwnmrtnz.poskocore.data.retrofit

import com.github.edwnmrtnz.poskocore.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

class RetrofitHelper {
    companion object {
        @JvmStatic
        var INSTANCE : RetrofitHelper? = null

        @JvmStatic
        fun newInstance(){
            if(INSTANCE == null)
                INSTANCE = RetrofitHelper()
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

    fun <S> createService(BASE_URL : String, basicAuth : String?, serviceClass : Class<S>, converterFactory : Converter.Factory) : S {
        val builder : Retrofit.Builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
        if(basicAuth != null){
            val httpClient : OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(Interceptor {
                val original : Request = it.request()

                val requestBuilder : Request.Builder = original.newBuilder().header("Authorization", basicAuth)
                requestBuilder.header("Accept", "application/json")
                requestBuilder.method(original.method(), original.body())

                val request : Request = requestBuilder.build()
                it.proceed(request)
            })

            val client : OkHttpClient = httpClient.build()
            builder.client(client)
        }

        return builder.build().create(serviceClass);
    }

}