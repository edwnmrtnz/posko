package com.edwnmrtnz.posko.sdk.auth.data.extension

import com.edwnmrtnz.posko.sdk.auth.data.db.model.SessionData
import com.edwnmrtnz.posko.sdk.auth.domain.model.Session

internal fun Session.toDatbase() : SessionData {
    return SessionData(
            userId,
            domain,
            token,
            status
    )
}

internal fun SessionData.toDomain () : Session {
    return Session(
            user_id,
            domain,
            token,
            status
    )
}