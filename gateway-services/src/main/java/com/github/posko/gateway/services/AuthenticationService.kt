package com.github.posko.gateway.services

import com.github.posko.gateway.services.model.User
import java.lang.Exception

/**
 * Created by edwinmartinez on June 17, 2019
 */
interface AuthenticationService {

    fun authenticate(domain : String, accountId : String, email : String, password : String, callback : ServiceCallback<User>)

}

class AuthService : AuthenticationService {
    override fun authenticate(domain: String, accountId: String, email: String, password: String, callback: ServiceCallback<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main() {
    val authService = AuthService()

    authService.authenticate(
        "domain",
        "account_id",
        "email",
        "password",
        object : ServiceCallback<User> {
            override fun onSuccess(result: User) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailed(exception: Exception) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    )
}