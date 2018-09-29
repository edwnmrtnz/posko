package com.github.posko.core.data.api.services

import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.domain.model.User
import kotlinx.coroutines.experimental.Deferred

interface PoskoServices {

    fun login(account_name : String, email : String, password : String) : Deferred<UserRaw>

}