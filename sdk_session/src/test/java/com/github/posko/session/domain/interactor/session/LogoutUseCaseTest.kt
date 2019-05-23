package com.github.posko.session.domain.interactor.session

import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LogoutUseCaseTest {

    private lateinit var usecase : LogoutUseCase

    @Mock private lateinit var gateway : SessionGateway

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        usecase = LogoutUseCase(
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun logout_shouldHaveNoProblems() = runBlocking {
        usecase.execute(Unit)

        Mockito.verify(gateway).signOut()
        Mockito.verifyNoMoreInteractions(gateway)
    }
}