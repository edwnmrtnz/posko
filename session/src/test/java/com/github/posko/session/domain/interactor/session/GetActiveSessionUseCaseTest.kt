package com.github.posko.session.domain.interactor.session

import com.github.posko.session.domain.exception.NoActiveSessionException
import com.github.posko.session.domain.gateway.SessionGateway
import com.github.posko.session.domain.model.Session
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineContext
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.Exception

class GetActiveSessionUseCaseTest {

    private lateinit var usecase : GetActiveSessionUseCase

    private var session : Session = Session(1, "http://localhost:3000", "token", "active")

    @Mock private lateinit var gateway : SessionGateway

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        usecase = GetActiveSessionUseCase (
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun getActiveSession_shouldReturnActiveSession()  = runBlocking {
        Mockito.`when`(gateway.getActiveSession()).thenReturn(session)

        val session =  usecase.execute(Unit).session

        assertNotNull(session)
        assertEquals(1, session.userId)

        Mockito.verify(gateway).getActiveSession()
        Mockito.verifyNoMoreInteractions(gateway)
    }

    @Test(expected = Exception::class)
    fun getActiveSession_shouldThrowAnException()  = runBlocking {
        Mockito.`when`(gateway.getActiveSession()).thenThrow(NoActiveSessionException::class.java)

        usecase.execute(Unit)

        Unit
    }
}