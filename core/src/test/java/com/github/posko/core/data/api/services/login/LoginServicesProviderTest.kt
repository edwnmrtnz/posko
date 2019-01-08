package com.github.posko.core.data.api.services.login

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
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

class LoginServicesProviderTest : UnitTest() {

    private lateinit var server : MockWebServer

    @Mock
    private lateinit var encryptor : Encryptor

    private lateinit var logger : ServiceLogger

    private lateinit var loginServicesProvider : LoginServicesProvider

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

        loginServicesProvider = LoginServicesProvider(serviceConfigProvider, gsonBuilder)
    }

    @After
    fun destroy() {
        server.shutdown()
    }

    @Test
    fun `should return a valid user`() = runBlocking {

        val userRaw = AssetReader.readJsonFile("stubs/user_sign_in.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(userRaw))

        val result = loginServicesProvider.
                loginUser(server.url("/api/v1/sign_in/").toString(), "hello", "hello", "hello")
                .await()

        doPrint(result)
    }

}