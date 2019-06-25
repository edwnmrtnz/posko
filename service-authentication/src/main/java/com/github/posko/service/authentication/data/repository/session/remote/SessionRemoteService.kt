package com.github.posko.service.authentication.data.repository.session.remote

import com.github.posko.service.authentication.domain.model.UserCookie

interface SessionRemoteService {

    suspend fun signIn(domain: String, accountName: String, email: String, password: String): UserCookie

    suspend fun signOut()
}