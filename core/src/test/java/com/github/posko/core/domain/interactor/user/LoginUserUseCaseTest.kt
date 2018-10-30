package com.github.posko.core.domain.interactor.user

import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.deserializer.UserDeserializer
import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.data.extension.toUser
import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.dispatcher.CoroutineDispatcherProvider
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class LoginUserUseCaseTest : UnitTest() {

    @Mock
    private lateinit var dispatcher: CoroutineDispatcherProvider

    @Mock
    private lateinit var gateway: UserGateway

    private lateinit var usecase: LoginUserUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        usecase = LoginUserUseCase(dispatcher, gateway)
    }

    @Test
    fun `should call user gateway`() = runBlocking {
        usecase.run(LoginUserUseCase.Param("","",""))

        verify(gateway).login("","","")
        verifyNoMoreInteractions(gateway)
    }

    @Test
    fun `should return a valid customer`() = runBlocking {
        val user : User = gsonBuilder.registerTypeAdapter(UserRaw::class.java, UserDeserializer())
                .create()
                .fromJson(readFile("stubs/user_sign_in.txt"), UserRaw::class.java).toUser()

        assertNotNull(user)

        assertEquals("admin@first_company.com", user.email)
    }
}