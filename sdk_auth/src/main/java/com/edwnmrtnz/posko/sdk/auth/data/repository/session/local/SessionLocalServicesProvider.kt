package com.edwnmrtnz.posko.sdk.auth.data.repository.session.local

import com.edwnmrtnz.posko.sdk.auth.data.db.dao.SessionDao
import com.edwnmrtnz.posko.sdk.auth.data.extension.toDatbase
import com.edwnmrtnz.posko.sdk.auth.data.extension.toDomain
import com.edwnmrtnz.posko.sdk.auth.domain.exception.NoActiveSessionException
import com.edwnmrtnz.posko.sdk.auth.domain.model.Session

class SessionLocalServicesProvider(private val dao : SessionDao) : SessionLocalServices {
    override suspend fun getActiveSession(): Session {
        return dao.getActiveSession()?.toDomain() ?: throw NoActiveSessionException()
    }

    override suspend fun save(session: Session) {
        dao.insert(session.toDatbase())
    }

}