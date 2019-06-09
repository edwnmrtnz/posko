package com.edwnmrtnz.posko.sdk.auth.data.repository.session.remote

import com.edwnmrtnz.posko.sdk.auth.domain.model.UserCookie

interface SessionRemoteServices {

    suspend fun signIn(domain : String, accountName : String, email : String, password : String) : UserCookie

    suspend fun signOut()
}