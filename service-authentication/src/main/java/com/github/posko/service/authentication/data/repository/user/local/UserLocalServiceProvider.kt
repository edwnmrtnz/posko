package com.github.posko.service.authentication.data.repository.user.local

import com.github.posko.service.authentication.data.db.dao.UserDao
import com.github.posko.service.authentication.data.extension.toDatabase
import com.github.posko.service.authentication.domain.model.User
import com.github.posko.core.exception.DataNotAvailableException
import com.github.posko.service.authentication.data.extension.toDomain

class UserLocalServiceProvider (
    private val dao: UserDao
) : UserLocalService {

    override fun save(user: User) {
        dao.insert(user.toDatabase())
    }

    override fun getById(userId: Int): User {
        return dao.getById(userId)?.toDomain() ?: throw DataNotAvailableException("No user found")
    }

    override fun destroy() {
        dao.destroy()
        return
    }
}