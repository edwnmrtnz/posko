package com.github.posko.session.domain.interactor.user

import com.github.posko.session.domain.gateway.UserGateway
import com.github.posko.session.domain.interactor.FakeUserDataProvider
import com.github.posko.sharedtest.helpers.TestCoroutineDispatcherProvider
import com.github.posko.sharedtest.helpers.any
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SaveUserUseCaseTest {

    private lateinit var usecase : SaveUserUseCase

    @Mock private lateinit var gateway: UserGateway

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        usecase = SaveUserUseCase(
                TestCoroutineDispatcherProvider(),
                gateway
        )
    }

    @Test
    fun shouldBeAbleToSaveUser() = runBlocking {

        usecase.execute(SaveUserUseCase.Param(FakeUserDataProvider.provideUser()))

        Mockito.verify(gateway).save(any())
        Mockito.verifyNoMoreInteractions(gateway)
    }
}