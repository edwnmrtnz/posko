package com.edwnmrtnz.posko.sdk.auth.data.repository.session.local

import com.edwnmrtnz.posko.sdk.auth.domain.model.Session

interface SessionLocalServices {

    suspend fun save(session : Session)

    suspend fun getActiveSession() : Session
}