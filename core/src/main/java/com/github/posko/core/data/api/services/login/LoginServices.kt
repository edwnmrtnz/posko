package com.github.posko.core.data.api.services.login

import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.domain.model.User
import kotlinx.coroutines.Deferred

interface LoginServices {

    suspend fun login(domain : String, account_name : String, email : String, password : String) : UserRaw


}