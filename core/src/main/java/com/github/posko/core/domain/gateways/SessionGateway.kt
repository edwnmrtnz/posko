package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Session

interface SessionGateway {

    suspend fun createSession(session : Session)

    suspend fun getSession() : Session
}