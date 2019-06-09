package com.edwnmrtnz.posko.sdk.auth.domain.gateway

import com.edwnmrtnz.posko.sdk.auth.domain.model.Session
import com.edwnmrtnz.posko.sdk.auth.domain.model.UserCookie

interface SessionGateway {

    suspend fun signIn(domain : String, accountName : String, email : String, password : String) : UserCookie

    suspend fun signOut()

    suspend fun save(session : Session)

    suspend fun getActiveSession() : Session
}