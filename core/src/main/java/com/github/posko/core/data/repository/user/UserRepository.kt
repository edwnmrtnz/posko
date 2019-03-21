package com.github.posko.core.data.repository.user

import com.github.posko.core.data.database.dao.UserDao
import com.github.posko.core.data.extension.toDatabase
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User

class UserRepository (private val dao : UserDao): UserGateway {
    override fun save(user: User) {
        dao.insert(user.toDatabase())
    }
}