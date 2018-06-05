package com.github.edwnmrtnz.posko.data.repository.user


import com.github.edwnmrtnz.posko.capture
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.verify

class UserRepositoryTest {

    private val ACCOUNT_ID  = "first_company"
    private val EMAIL       = "admin@first_company.com"
    private val PASSWORD    = "pass"

    @Mock private lateinit var userLocalDataSource : UserDataSource
    @Mock private lateinit var userRemoteDataSource: UserDataSource
    @Mock private lateinit var authenticateUserCallback: UserDataSource.AuthenticateUserCallback

    @Captor private lateinit var authenticateUserCallbackCaptor : ArgumentCaptor<UserDataSource.AuthenticateUserCallback>

    private lateinit var userRepository: UserRepository

    @Before
    fun setup(){

        MockitoAnnotations.initMocks(this)

        userRepository = UserRepository.getInstance(userLocalDataSource, userRemoteDataSource)
    }

    @After
    fun destroy(){
        UserRepository.destroyInstance()
    }


    @Test
    fun authenticateUserWithCorrectCredentialsTest(){
        //When a request to authenticate user from user repository was called
        userRepository.authenticateUser(ACCOUNT_ID, EMAIL, PASSWORD, authenticateUserCallback)

        //Then remote data source's authenticate user method must be called
        verify(userRemoteDataSource).authenticateUser(
                Matchers.anyString(),
                Matchers.anyString(),
                Matchers.anyString(),
                capture(authenticateUserCallbackCaptor))
    }

}