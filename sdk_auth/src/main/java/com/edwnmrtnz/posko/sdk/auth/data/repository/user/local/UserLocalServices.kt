package com.edwnmrtnz.posko.sdk.auth.data.repository.user.local

import com.edwnmrtnz.posko.sdk.auth.domain.model.User

interface UserLocalServices {

    fun save(user : User)

    fun getById(userId : Int) : User

    fun destroy()
}