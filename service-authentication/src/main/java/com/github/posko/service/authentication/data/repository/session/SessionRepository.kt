package com.github.posko.service.authentication.data.repository.session

import com.github.posko.service.authentication.data.repository.session.local.SessionLocalService
import com.github.posko.service.authentication.data.repository.session.remote.SessionRemoteService
import com.github.posko.service.authentication.domain.gateway.SessionGateway
import com.github.posko.service.authentication.domain.model.Session
import com.github.posko.service.authentication.domain.model.UserCookie

class SessionRepository (
    private val local: SessionLocalService,
    private val remote: SessionRemoteService
) : SessionGateway {


    override suspend fun signIn(domain: String, accountName: String, email: String, password: String): UserCookie {
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
