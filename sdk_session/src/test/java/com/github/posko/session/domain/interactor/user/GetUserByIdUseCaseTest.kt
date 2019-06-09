package com.github.posko.session.domain.interactor.user

import com.github.posko.base.sdk.exception.DataNotAvailableException
import com.github.posko.session.domain.gateway.UserGateway
import com.github.posko.session.domain.interactor.FakeUserDataProvider
import com.github.posko.session.domain.model.User
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetUserByIdUseCaseTest {

    private lateinit var usecase : GetUserByIdUseCase

    @Mock private lateinit var gateway : UserGateway

    private var user : User = FakeUserDataProvider.provideUser()
    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        usecase = GetUserByIdUseCase(
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun getUserById_shouldReturnAValidUse() = runBlocking {
        Mockito.`when`(gateway.getById(1)).thenReturn(user)

        val user = usecase.execute(GetUserByIdUseCase.Param(1)).user

        assertNotNull(user)
        assertEquals(1, user.id)

        Mockito.verify(gateway).getById(1)
        Mockito.verifyNoMoreInteractions(gateway)
    }

    @Test(expected = Exception::class)
    fun getUserById_shouldThrowAnException()= runBlocking {
        Mockito.`when`(gateway.getById(1)).thenThrow(DataNotAvailableException("No user available"))

        val user = usecase.execute(GetUserByIdUseCase.Param(1)).user

        assertNotNull(user)
    }
}