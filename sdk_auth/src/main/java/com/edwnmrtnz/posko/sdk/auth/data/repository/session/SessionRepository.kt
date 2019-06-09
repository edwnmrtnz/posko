package com.edwnmrtnz.posko.sdk.auth.data.repository.session

import com.edwnmrtnz.posko.sdk.auth.data.repository.session.local.SessionLocalServices
import com.edwnmrtnz.posko.sdk.auth.data.repository.session.remote.SessionRemoteServices
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.SessionGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.Session
import com.edwnmrtnz.posko.sdk.auth.domain.model.UserCookie

class SessionRepository(private val local : SessionLocalServices,
                        private val remote : SessionRemoteServices): SessionGateway {


    override suspend fun signIn(domain : String, accountName: String, email: String, password: String): UserCookie {
        return remote.signIn(domain, accountName, email, password)
    }

    override suspend fun signOut() {
        return remote.signOut()
    }

    override suspend fun save(session: Session) {
        return local.save(session)
    }
    override suspend fun getActiveSession(): Session {
        return local.getActiveSession()
    }
}
