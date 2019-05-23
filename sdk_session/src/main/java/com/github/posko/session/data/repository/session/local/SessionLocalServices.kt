package com.github.posko.session.data.repository.session.local

import com.github.posko.session.domain.model.Session

interface SessionLocalServices {

    suspend fun save(session : Session)

    suspend fun getActiveSession() : Session
}