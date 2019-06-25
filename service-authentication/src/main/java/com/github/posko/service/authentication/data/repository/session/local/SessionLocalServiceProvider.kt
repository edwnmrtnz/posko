package com.github.posko.service.authentication.data.repository.session.local

import com.github.posko.service.authentication.data.db.dao.SessionDao
import com.github.posko.service.authentication.data.extension.toDatbase
import com.github.posko.service.authentication.data.extension.toDomain
import com.github.posko.service.authentication.domain.exception.NoActiveSessionException
import com.github.posko.service.authentication.domain.model.Session

class SessionLocalServiceProvider (
    private val dao: SessionDao
) : SessionLocalService {

    override suspend fun getActiveSession(): Session {
        return dao.getActiveSession()?.toDomain() ?: throw NoActiveSessionException()
    }

    override suspend fun save(session: Session) {
        dao.insert(session.toDatbase())
    }

}