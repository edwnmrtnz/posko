package com.github.posko.session.data.repository.user

import com.github.posko.session.data.repository.user.local.UserLocalServices
import com.github.posko.session.data.repository.user.remote.UserRemoteServices
import com.github.posko.session.domain.gateway.UserGateway
import com.github.posko.session.domain.model.User

class UserRepository(val local : UserLocalServices,
                     val remote : UserRemoteServices) : UserGateway {

    override fun save(user: User) {
        local.save(user)
    }

    override fun getById(userId: Int): User {
        return local.getById(userId)
    }

    override fun destroy() {
        local.destroy()
    }
}