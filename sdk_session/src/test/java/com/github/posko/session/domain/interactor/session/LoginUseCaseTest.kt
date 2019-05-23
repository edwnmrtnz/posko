package com.github.posko.session.domain.interactor.session

import com.github.posko.session.data.api.deserializer.UserDeserializer
import com.github.posko.session.data.api.model.UserRaw
import com.github.posko.session.data.extension.toDomain
import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.session.domain.interactor.user.SaveUserUseCase
import com.github.posko.session.domain.model.User
import com.github.posko.session.domain.model.UserCookie
import com.github.posko.sharedtest.fakes.SessionFakeData
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class LoginUseCaseTest {

    private lateinit var usecase : LoginUseCase

    @Mock lateinit var gateway : SessionGateway
    @Mock lateinit var saveSessionUseCase: SaveSessionUseCase
    @Mock lateinit var saveUserCase : SaveUserUseCase
    private var user : User = GsonBuilder().registerTypeAdapter(
            UserRaw::class.java, UserDeserializer()
    ).create().fromJson(SessionFakeData.getUser(), UserRaw::class.java).toDomain()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        usecase = LoginUseCase(
                TestCoroutineDispatcherProvider(),
                gateway,
                saveSessionUseCase,
                saveUserCase
        )
    }

    @Test
    fun login_shouldReturnValidUser() = runBlocking {
        `when`(gateway.signIn("","","","")).thenReturn(UserCookie(user, "cookie"))

        val user = usecase.execute(LoginUseCase.Param("","","","")).user

        verify(gateway).signIn("","","","")
        verifyNoMoreInteractions(gateway)

        val inOrder = inOrder(saveSessionUseCase, saveUserCase)
        inOrder.verify(saveSessionUseCase).execute(com.github.posko.sharedtest.helpers.any())
        inOrder.verify(saveUserCase).execute(com.github.posko.sharedtest.helpers.any())


        assertNotNull(user)
        assertEquals(1, user.id)
    }
}