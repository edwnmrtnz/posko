package com.github.posko.core.data.api.services.products

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfigProvider
import com.github.posko.core.data.api.generator.Encryptor
import com.github.posko.core.data.api.generator.ServiceLogger
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProductsServicesProviderTest : UnitTest() {
    private lateinit var server : MockWebServer

    @Mock
    private lateinit var encryptor : Encryptor

    @Mock public lateinit var authorization: RequestAuthorization

    private lateinit var logger : ServiceLogger

    private lateinit var productServices : ProductsServicesProvider

    private lateinit var serviceConfigProvider: ServiceConfigProvider

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

        logger = Mockito.spy(ServiceLogger::class.java)

        server = MockWebServer()
        server.start()

        Mockito.`when`(encryptor.basicAuthentication(Mockito.anyString(), Mockito.anyString())).thenReturn("")
        Mockito.doNothing().`when`(logger).log(Mockito.anyString(), Mockito.anyString())

        serviceConfigProvider = ServiceConfigProvider(encryptor, logger)

        productServices = ProductsServicesProvider(serviceConfigProvider, authorization)

        Mockito.`when`(authorization.getUsername()).thenReturn("")
        Mockito.`when`(authorization.getPassword()).thenReturn("")
        Mockito.`when`(authorization.getDomain()).thenReturn(server.url(".api/").toString())
    }

    @After
    fun destroy() {
        server.shutdown()
    }

    @Test
    fun `should return a valid list of product with its variants`() = runBlocking {
        val raw = AssetReader.readJsonFile("stubs/products_with_variants.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(raw))

        val result = productServices.fetchProducts(hashMapOf())

        doPrint(result)

    }
}