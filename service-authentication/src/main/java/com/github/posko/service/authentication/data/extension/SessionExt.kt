package com.github.posko.service.authentication.data.extension

import com.github.posko.service.authentication.data.db.model.SessionData
import com.github.posko.service.authentication.domain.model.Session

internal fun Session.toDatbase(): SessionData {
    return SessionData(
            userId,
            domain,
            token,
            status
    )
}

internal fun SessionData.toDomain(): Session {
    return Session(
            user_id,
            domain,
            token,
            status
    )
}