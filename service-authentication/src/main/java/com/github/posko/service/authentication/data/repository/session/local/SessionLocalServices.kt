package com.github.posko.service.authentication.data.repository.session.local

import com.github.posko.service.authentication.domain.model.Session

interface SessionLocalServices {

    suspend fun save(session: Session)

    suspend fun getActiveSession(): Session
}