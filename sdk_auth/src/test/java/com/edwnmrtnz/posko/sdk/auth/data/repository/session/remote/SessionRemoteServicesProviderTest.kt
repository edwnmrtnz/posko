package com.edwnmrtnz.posko.sdk.auth.data.repository.session.remote

import com.edwnmrtnz.posko.sdk.auth.data.repository.session.remote.SessionRemoteServices

class SessionRemoteServicesProviderTest {

    private lateinit var remoteService : SessionRemoteServices
//
//    @Before
//    fun setup() {
//        remoteService = SessionRemoteServicesProvider(
//                RestClient.Builder()
//                        .setBaseUrl("http://localhost:3000")
//                        .setLogger(object : ServiceLogger {
//                            override fun log(tag: String, message: String) {
//                                System.out.println(message)
//                            }
//                        })
//                        .setEnableLogging(true)
//        )
//    }
//
//    @Test
//    fun signIn() = runBlocking {
//        val userWithCookie = remoteService.signIn("http://localhost:3000","example", "posko@example.com","posko")
//
//        assertNotNull(userWithCookie)
//        assertEquals(userWithCookie.user.id, 1)
//        assertNotNull(userWithCookie.cookie)
//    }
}