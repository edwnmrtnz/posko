
package com.edwnmrtnz.posko.sdk.auth.data.repository.user.local

import com.github.posko.base.sdk.exception.DataNotAvailableException
import com.edwnmrtnz.posko.sdk.auth.data.db.dao.UserDao
import com.edwnmrtnz.posko.sdk.auth.data.extension.toDatabase
import com.edwnmrtnz.posko.sdk.auth.data.extension.toDomain
import com.edwnmrtnz.posko.sdk.auth.domain.model.User

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