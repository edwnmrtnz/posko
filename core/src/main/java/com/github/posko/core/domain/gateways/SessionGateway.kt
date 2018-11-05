package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Session

interface SessionGateway {

    interface CheckSessionCallback {

        fun hasValidSession(session : Session)

        fun noSessionFound()
    }

    fun checkSession (callback : CheckSessionCallback)

    suspend fun createSession(session : Session)

    suspend fun getSession() : Session?

}