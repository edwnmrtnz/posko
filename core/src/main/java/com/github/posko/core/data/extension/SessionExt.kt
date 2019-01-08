package com.github.posko.core.data.extension

import com.github.posko.core.data.database.model.SessionData
import com.github.posko.core.domain.model.Session

fun Session.toSessionData() : SessionData {
    return SessionData(id, domain, authToken, token)
}

fun SessionData.toSession() : Session {
    return Session(id, domain, authToken, token)
}