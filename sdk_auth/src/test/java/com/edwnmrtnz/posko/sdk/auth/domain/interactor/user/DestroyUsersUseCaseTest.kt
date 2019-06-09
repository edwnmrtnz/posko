package com.edwnmrtnz.posko.sdk.auth.domain.interactor.user

import com.edwnmrtnz.posko.sdk.auth.domain.gateway.UserGateway
import com.edwnmrtnz.posko.sdk.auth.domain.interactor.user.DestroyUsersUseCase
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DestroyUsersUseCaseTest {

    private lateinit var usecase : DestroyUsersUseCase

    @Mock private lateinit var gateway : UserGateway

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        usecase = DestroyUsersUseCase(
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun shouldDestroyUserData() = runBlocking {

        usecase.execute(Unit)

        Mockito.verify(gateway).destroy()
        Mockito.verifyNoMoreInteractions(gateway)
    }

}