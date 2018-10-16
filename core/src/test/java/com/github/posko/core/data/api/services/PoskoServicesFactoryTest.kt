@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package com.github.posko.core.data.api.services

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.config.ServiceConfigProvider
import com.github.posko.core.data.api.deserializer.ProductsDeserializer
import com.github.posko.core.data.api.endpoints.ProductsServicesApi
import com.github.posko.core.data.api.generator.Encryptor
import com.github.posko.core.data.api.generator.ServiceLogger
import com.github.posko.core.data.api.model.ProductRaw
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

import org.junit.Test

import kotlinx.coroutines.experimental.runBlocking
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.junit.Assert.*


class PoskoServicesFactoryTest : UnitTest() {

    private lateinit var server : MockWebServer
    private lateinit var services : PoskoServicesFactory

    @Mock private lateinit var encryptor : Encryptor

    private lateinit var logger : ServiceLogger
    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

        logger = Mockito.spy(ServiceLogger::class.java)

        server = MockWebServer()
        server.start()

        Mockito.`when`(encryptor.basicAuthentication(Mockito.anyString(), Mockito.anyString())).thenReturn("")
        Mockito.doNothing().`when`(logger).log(Mockito.anyString(), Mockito.anyString())
    }

    @After
    fun destroy() {
        server.shutdown()
    }


    @Test
    fun `should return a valid user after login`() = runBlocking {

        val config = ServiceConfigProvider(server.url("/api/v1/sign_in/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val userRaw = AssetReader.readJsonFile("stubs/user_sign_in.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(userRaw))

        val result = services.login("hello", "hello", "hello").await().body()

        doPrint(result!!)
    }

    @Test
    fun `should return a valid list of products`() = runBlocking {

        val config = ServiceConfigProvider(server.url("/api/v1/products/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val productsRaw = AssetReader.readJsonFile("stubs/products.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(productsRaw))

        val result = services.getProducts().await().body()

        doPrint(result!!)
    }

    @Test
    fun `should return a valid list of product variants given a product id`() = runBlocking {
        val config = ServiceConfigProvider(server.url("/api/v1/products/1/variants/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val productsVariantsRaw = AssetReader.readJsonFile("stubs/product_variants.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(productsVariantsRaw))

        val result = services.getProductVariants(1).await().body()

        doPrint(result!!)
    }

    @Test
    fun `should return a valid list of invoice`() = runBlocking {
        val config = ServiceConfigProvider(server.url("/api/v1/invoices/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val invoicesRaw = AssetReader.readJsonFile("stubs/invoices.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(invoicesRaw))

        val result = services.getInvoices().await().body()

        assertNotNull(result)
        assertEquals(3, result!!.size)

        doPrint(result)
    }

    @Test
    fun `should return a valid list invoice lines given an invoice id` () =  runBlocking {
        val config = ServiceConfigProvider(server.url("api/v1/invoices/1/invoice_lines/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val invoiceLinesRaw = AssetReader.readJsonFile("stubs/invoice_lines.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(invoiceLinesRaw))

        val result = services.getInvoiceLines(1).await().body()

        assertNotNull(result)

        assertEquals(2, result!!.size)

        doPrint(result)
    }
}