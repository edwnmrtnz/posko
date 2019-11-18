package com.github.posko.domain.services

import com.github.posko.domain.services.model.PoskoUser

/**
 * Created by edwinmartinez on June 17, 2019
 */
interface AuthenticationService {

    fun authenticate(domain : String, accountId : String, email : String, password : String, callback : ServiceCallback<PoskoUser>)

}

