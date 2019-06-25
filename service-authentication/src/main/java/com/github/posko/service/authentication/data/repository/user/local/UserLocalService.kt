package com.github.posko.service.authentication.data.repository.user.local

import com.github.posko.service.authentication.domain.model.User

interface UserLocalService {

    fun save(user: User)

    fun getById(userId: Int): User

    fun destroy()
}