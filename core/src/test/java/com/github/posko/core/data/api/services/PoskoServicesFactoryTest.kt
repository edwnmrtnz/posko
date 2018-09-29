@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package com.github.posko.core.data.api.services

import com.github.posko.core.AssetReader
import com.google.gson.GsonBuilder
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

import org.junit.Test

import kotlinx.coroutines.experimental.runBlocking

class PoskoServicesFactoryTest {

    private lateinit var server : MockWebServer
    private lateinit var services : PoskoServicesFactory

    @Before
    fun setUp() {
        server = MockWebServer()
        server.start()
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
        services = PoskoServicesFactory(server.url("/api/v1/sign_in/").toString())

        val userRaw = AssetReader.readJsonFile("stubs/user_sign_in.txt")

        server.enqueue(MockResponse().setResponseCode(200).setBody(userRaw))

        val result = services.login("hello", "hello", "hello").await()

        print(result)
    }
}