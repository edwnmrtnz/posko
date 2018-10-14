package com.github.posko.core.data.api.services

import android.util.Log
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.ProductsDeserializer
import com.github.posko.core.data.api.deserializer.UserDeserializer
import com.github.posko.core.data.api.endpoints.ProductsServicesApi
import com.github.posko.core.data.api.endpoints.UserServicesApi
import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.domain.model.User
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class PoskoServicesFactory(private val config: ServiceConfiguration) : PoskoServices {


    private var gsonBuilder = GsonBuilder().setPrettyPrinting()

    override fun login(account_name: String, email: String, password: String): Deferred<Response<UserRaw>> {
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

    override fun getProducts(): Deferred<Response<List<ProductRaw>>> {
        val listType = object : TypeToken<MutableList<ProductRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listType, ProductsDeserializer())
                .create()

        return config
                .getConfig()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("get_products")
                .build()
                .generateService(ProductsServicesApi::class.java)
                .getProducts()
    }

    companion object {
        const val TAG = "PoskoServicesFactory"
    }

}