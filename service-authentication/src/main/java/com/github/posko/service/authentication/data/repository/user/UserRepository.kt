package com.github.posko.service.authentication.data.repository.user

import com.github.posko.service.authentication.data.repository.user.local.UserLocalService
import com.github.posko.service.authentication.data.repository.user.remote.UserRemoteService
import com.github.posko.service.authentication.domain.gateway.UserGateway
import com.github.posko.service.authentication.domain.model.User

class UserRepository (
    private val local: UserLocalService,
    private val remote: UserRemoteService
) : UserGateway {

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