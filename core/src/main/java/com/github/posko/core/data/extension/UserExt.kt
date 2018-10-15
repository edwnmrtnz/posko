package com.github.posko.core.data.extension

import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.data.database.model.UserData
import com.github.posko.core.domain.model.User

fun UserRaw.toUserData() : UserData {
    return UserData(email, first_name, last_name, token, auth_token, created_at)
}

fun UserData.toUser() : User {
    return User(email, firstName, lastName, token, authToken, createdAt)
}