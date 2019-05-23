package com.github.posko.session.data.repository.session.remote

import com.github.posko.session.domain.model.UserCookie

interface SessionRemoteServices {

    suspend fun signIn(domain : String, accountName : String, email : String, password : String) : UserCookie

    suspend fun signOut()
}