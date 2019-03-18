package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.*
import com.github.posko.core.data.api.endpoints.*
import com.github.posko.core.data.api.model.*
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Deferred
import retrofit2.converter.gson.GsonConverterFactory

class PoskoServicesFactory(private val config: ServiceConfiguration,
                           private val authorization: RequestAuthorization) : PoskoServices {

    private var gsonBuilder = GsonBuilder().setPrettyPrinting()

    override fun login(domain :String,account_name: String, email: String, password: String): Deferred<UserRaw> {
        val gson = gsonBuilder
                .registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(domain)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("login")
                .build()
                .generateService(UserServiceEndpoints::class.java)
                .login(account_name, email, password)
    }

    override fun getProducts(): Deferred<List<ProductRaw>> {
        val listType = object : TypeToken<MutableList<ProductRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listType, ProductsDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(authorization.getDomain())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setBasicAuth(authorization.getUsername(), authorization.getPassword())
                .setEnableLogging("get_products")
                .build()
                .generateService(ProductsServiceEndpoints::class.java)
                .getProducts()
    }

    override fun getProductVariant(product_id: Int): Deferred<List<ProductVariantRaw>> {
        val listType = object : TypeToken<MutableList<ProductVariantRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listType, ProductVariantsDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(authorization.getDomain())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setBasicAuth(authorization.getUsername(), authorization.getPassword())
                .setEnableLogging("get_product_variants_for $product_id")
                .build()
                .generateService(ProductVariantServiceEndpoints::class.java)
                .getProductVariants(product_id)
    }

    override fun getProductVariants(queryParam: HashMap<String, String>): Deferred<List<ProductVariantRaw>> {
        val listType = object : TypeToken<MutableList<ProductVariantRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listType, ProductVariantsDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(authorization.getDomain())
                .setBasicAuth(authorization.getUsername(), authorization.getPassword())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setEnableLogging("get_product_variants")
                .build()
                .generateService(ProductVariantServiceEndpoints::class.java)
                .getProductVariants(queryParam)
    }

    override fun getInvoices(): Deferred<List<InvoiceRaw>> {
        val listType = object : TypeToken<MutableList<InvoiceRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listType, InvoiceDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(authorization.getDomain())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setBasicAuth(authorization.getUsername(), authorization.getPassword())
                .setEnableLogging("get_invoices")
                .build()
                .generateService(InvoiceServiceEndpoints::class.java)
                .getInvoices()
    }

    override fun getInvoiceLines(invoice_id: Int): Deferred<List<InvoiceLineRaw>> {
        val listype = object : TypeToken<MutableList<InvoiceLineRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listype, InvoiceLineDeserializer())
                .create()
        return config
                .getConfig()
                .setBaseUrl(authorization.getDomain())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .setBasicAuth(authorization.getUsername(), authorization.getPassword())
                .setEnableLogging("get_invoice_lines")
                .build()
                .generateService(InvoiceLinesServiceEndpoints::class.java)
                .getInvoiceLines(invoice_id)
    }



    companion object {
        const val TAG = "PoskoServicesFactory"
    }
}