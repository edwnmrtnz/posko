@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package com.github.posko.core.data.api.services

import com.github.posko.core.AssetReader
import com.github.posko.core.data.api.config.ServiceConfigProvider
import com.github.posko.core.data.api.generator.Encryptor
import com.github.posko.core.data.api.generator.ServiceLogger
import com.google.gson.GsonBuilder
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

import org.junit.Test

import kotlinx.coroutines.experimental.runBlocking
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class PoskoServicesFactoryTest {

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

    private fun print(any : Any) {
        System.out.println(GsonBuilder().setPrettyPrinting().create().toJson(any))
    }

    @Test
    fun `should return a valid user after login`() = runBlocking {

        val config = ServiceConfigProvider(server.url("/api/v1/sign_in/").toString(), encryptor, logger)

        services = PoskoServicesFactory(config)

        val userRaw = AssetReader.readJsonFile("stubs/user_sign_in.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(userRaw))

        val result = services.login("hello", "hello", "hello").await()

        print(result)
    }
}