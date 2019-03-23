package com.github.posko.core.data.api.services.products

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.ProductsDeserializer
import com.github.posko.core.data.api.deserializer.ProductsWithVariantsDeserializer
import com.github.posko.core.data.api.endpoints.ProductsServiceEndpoints
import com.github.posko.core.data.api.model.CountRaw
import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import com.github.posko.shared.exception.HttpErrorException
import com.github.posko.shared.exception.ServiceException
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ProductsServicesProvider(private val config : ServiceConfiguration,
                               private val requestAuthorization: RequestAuthorization) : ProductServices {

    override suspend fun fetchProducts(params: HashMap<String, String>): MutableList<ProductWithVariantsRaw> {
        val listType = object : TypeToken<MutableList<ProductWithVariantsRaw>>() {}.type

        val gson = GsonBuilder()
                .registerTypeAdapter(listType, ProductsWithVariantsDeserializer())
                .create()

        return suspendCancellableCoroutine {
            config.getConfig()
                    .setEnableLogging("fetch_products")
                    .setBasicAuth(requestAuthorization.getUsername(), requestAuthorization.getPassword())
                    .setBaseUrl(requestAuthorization.getDomain())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .generateService(ProductsServiceEndpoints::class.java)
                    .getProducts(params)
                    .enqueue(object : Callback<MutableList<ProductWithVariantsRaw>> {
                        override fun onFailure(call: Call<MutableList<ProductWithVariantsRaw>>, t: Throwable) {
                            it.resumeWithException(ServiceException(t.localizedMessage))
                        }
                        override fun onResponse(call: Call<MutableList<ProductWithVariantsRaw>>, response: Response<MutableList<ProductWithVariantsRaw>>) {
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

    override suspend fun fetchCount(params: HashMap<String, String>): Int {
        return suspendCancellableCoroutine {
            config.getConfig()
                    .setEnableLogging("fetch_product_count")
                    .setBasicAuth(requestAuthorization.getUsername(), requestAuthorization.getPassword())
                    .setBaseUrl(requestAuthorization.getDomain())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .generateService(ProductsServiceEndpoints::class.java)
                    .getCount(params)
                    .enqueue(object : Callback<CountRaw> {
                        override fun onFailure(call: Call<CountRaw>, t: Throwable) {
                            it.resumeWithException(ServiceException(t.message!!))
                        }
                        override fun onResponse(call: Call<CountRaw>, response: Response<CountRaw>) {
                            if(response.isSuccessful) {
                                it.resume(response.body()!!.count)
                            } else {
                                it.resumeWithException(HttpErrorException(response.code(),
                                        response.errorBody()?.string() ?: "Something went wrong"))
                            }
                        }
                    })
        }
    }
}