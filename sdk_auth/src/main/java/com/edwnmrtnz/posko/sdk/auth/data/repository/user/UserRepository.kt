package com.edwnmrtnz.posko.sdk.auth.data.repository.user

import com.edwnmrtnz.posko.sdk.auth.data.repository.user.local.UserLocalServices
import com.edwnmrtnz.posko.sdk.auth.data.repository.user.remote.UserRemoteServices
import com.edwnmrtnz.posko.sdk.auth.domain.gateway.UserGateway
import com.edwnmrtnz.posko.sdk.auth.domain.model.User

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