
package com.github.posko.session.data.repository.user.local

import com.github.posko.base.exception.DataNotAvailableException
import com.github.posko.session.data.db.dao.UserDao
import com.github.posko.session.data.extension.toDatabase
import com.github.posko.session.data.extension.toDomain
import com.github.posko.session.domain.model.User

class UserLocalServicesProvider(private val dao : UserDao) : UserLocalServices {

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