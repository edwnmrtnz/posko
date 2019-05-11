package com.github.posko.session.domain.interactor.session

import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.session.domain.model.Session
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import com.github.posko.sharedtest.helpers.any
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SaveSessionUseCaseTest {

    private lateinit var usecase : SaveSessionUseCase

    @Mock private lateinit var gateway : SessionGateway

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        usecase = SaveSessionUseCase(
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun saveSession_shouldSaveSession() = runBlocking {
        usecase.execute(SaveSessionUseCase.Param(
                Session(
                        1,"http://localhost:3000", "coockie", "active"
                )
        ))

        Mockito.verify(gateway).save(any())
        Mockito.verifyNoMoreInteractions(gateway)
    }

}