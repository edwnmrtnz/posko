package com.github.posko.core.data.extension

import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.data.database.model.UserData
import com.github.posko.core.domain.model.User

fun UserRaw.toDatabase() : UserData {
    return UserData(id, email, first_name, last_name, token, auth_token, created_at)
}

fun User.toDatabase() : UserData {
    return UserData(id, email, firstName, lastName, token, authToken, createdAt)
}

fun UserRaw.toDomain() : User {
    return User(id, email, first_name, last_name, token, auth_token, created_at)
}

fun UserData.toDomain() : User {
    return User(id, email, first_name, last_name, token, auth_token, created_at)
}