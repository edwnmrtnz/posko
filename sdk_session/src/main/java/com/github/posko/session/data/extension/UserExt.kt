package com.github.posko.session.data.extension

import com.github.posko.session.data.api.model.UserRaw
import com.github.posko.session.data.db.model.UserData
import com.github.posko.session.domain.model.User

fun UserRaw.toDomain() : User {
    return User (
            id,
            account_id,
            email,
            first_name,
            last_name,
            middle_name,
            suffix,
            status,
            user_status
    )
}

fun User.toDatabase() : UserData {
    return UserData (
            id,
            accountId,
            email,
            firstName,
            lastName,
            middleName,
            suffix,
            status,
            userStatus
    )
}

fun UserData.toDomain() : User {
    return User (
            id,
            account_id,
            email,
            first_name,
            last_name,
            middle_name,
            suffix,
            status,
            user_status
    )
}