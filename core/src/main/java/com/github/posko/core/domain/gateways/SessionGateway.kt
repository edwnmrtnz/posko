package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Session

interface SessionGateway {

    fun createSession(session : Session)

    fun getSession()
}