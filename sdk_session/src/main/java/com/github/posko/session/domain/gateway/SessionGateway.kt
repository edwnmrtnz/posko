package com.github.posko.session.domain.gateway

import com.github.posko.session.domain.model.Session
import com.github.posko.session.domain.model.UserCookie

interface SessionGateway {

    suspend fun signIn(domain : String, accountName : String, email : String, password : String) : UserCookie

    suspend fun signOut()

    suspend fun save(session : Session)

    suspend fun getActiveSession() : Session
}