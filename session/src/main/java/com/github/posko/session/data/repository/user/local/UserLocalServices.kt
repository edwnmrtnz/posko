package com.github.posko.session.data.repository.user.local

import com.github.posko.session.domain.model.User

interface UserLocalServices {

    fun save(user : User)

    fun getById(userId : Int) : User

    fun destroy()
}