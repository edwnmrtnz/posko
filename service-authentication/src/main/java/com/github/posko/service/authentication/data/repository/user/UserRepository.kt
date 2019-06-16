package com.github.posko.service.authentication.data.repository.user

import com.github.posko.service.authentication.data.repository.user.local.UserLocalServices
import com.github.posko.service.authentication.data.repository.user.remote.UserRemoteServices
import com.github.posko.service.authentication.domain.gateway.UserGateway
import com.github.posko.service.authentication.domain.model.User

class UserRepository(val local: UserLocalServices,
                     val remote: UserRemoteServices) : UserGateway {

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