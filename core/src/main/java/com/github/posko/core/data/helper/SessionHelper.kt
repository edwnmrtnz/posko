package com.github.posko.core.data.helper

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.database.dao.SessionDao
import com.github.posko.core.data.extension.toSession
import com.github.posko.core.data.extension.toSessionData
import com.github.posko.core.domain.gateways.SessionGateway
import com.github.posko.core.domain.model.Session

class SessionHelper(val dao : SessionDao) : SessionGateway, RequestAuthorization {
    override fun getDomain(): String {
        return dao.getSession()!!.domain
    }

    override fun checkSession(callback: SessionGateway.CheckSessionCallback) {
        val session = dao.getSession()
        if(session == null) callback.noSessionFound()
        else callback.hasValidSession(session.toSession())
    }

    override suspend fun getSession(): Session? {
       return if(dao.getSession() == null) {
           null
       } else {
           dao.getSession()!!.toSession()
       }
    }

    override suspend fun createSession(session: Session) {
        dao.insert(session.toSessionData())
    }

    override fun getUsername(): String {
       return dao.getSession()!!.token
    }

    override fun getPassword(): String {
       return dao.getSession()!!.authToken
    }
}