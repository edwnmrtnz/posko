package com.github.posko.gs.posko

import com.github.posko.gateway.services.AuthenticationService
import com.github.posko.gateway.services.ServiceCallback
import com.github.posko.gateway.services.model.User
import com.github.posko.service.authentication.domain.interactor.session.LoginUseCase
import javax.inject.Inject

/**
 * Created by edwinmartinez on July 07, 2019
 */
class AuthenticationServiceProvider @Inject constructor (
    private var loginUseCase: LoginUseCase
) : AuthenticationService {

    override fun authenticate(domain: String, accountId: String, email: String, password: String, callback: ServiceCallback<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}