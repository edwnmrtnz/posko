package com.github.posko

import com.github.posko.domain.services.AuthenticationService
import com.github.posko.domain.services.ServiceCallback
import com.github.posko.domain.services.model.PoskoUser
import com.github.posko.service.authentication.domain.interactor.session.LoginUseCase
import javax.inject.Inject

/**
 * Created by edwinmartinez on July 07, 2019
 */
class AuthenticationServiceProvider @Inject constructor (
    private var loginUseCase: LoginUseCase
) : AuthenticationService {

    override fun authenticate(domain: String, accountId: String, email: String, password: String, callback: ServiceCallback<PoskoUser>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}