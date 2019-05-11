package com.github.posko.session.data.repository.session.local

import com.github.posko.session.data.db.dao.SessionDao
import com.github.posko.session.data.extension.toDatbase
import com.github.posko.session.data.extension.toDomain
import com.github.posko.session.domain.exception.NoActiveSessionException
import com.github.posko.session.domain.model.Session

class SessionLocalServicesProvider(private val dao : SessionDao) : SessionLocalServices {
    override suspend fun getActiveSession(): Session {
        return dao.getActiveSession()?.toDomain() ?: throw NoActiveSessionException()
    }

    override suspend fun save(session: Session) {
        dao.insert(session.toDatbase())
    }

}