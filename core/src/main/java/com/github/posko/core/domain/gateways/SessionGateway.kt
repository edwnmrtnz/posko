package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Session

interface SessionGateway {

    suspend fun create(session : Session)

    suspend fun get() : Session
}