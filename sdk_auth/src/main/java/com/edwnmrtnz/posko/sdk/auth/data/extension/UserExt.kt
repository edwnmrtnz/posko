package com.edwnmrtnz.posko.sdk.auth.data.extension

import com.edwnmrtnz.posko.sdk.auth.data.api.model.UserRaw
import com.edwnmrtnz.posko.sdk.auth.data.db.model.UserData
import com.edwnmrtnz.posko.sdk.auth.domain.model.User

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