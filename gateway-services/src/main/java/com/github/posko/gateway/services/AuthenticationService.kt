package com.github.posko.gateway.services

import com.github.posko.gateway.services.model.User
import java.lang.Exception

/**
 * Created by edwinmartinez on June 17, 2019
 */
interface AuthenticationService {

    fun authenticate(domain : String, accountId : String, email : String, password : String, callback : ServiceCallback<User>)

}

