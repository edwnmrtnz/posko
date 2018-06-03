package com.github.edwnmrtnz.posko.data.repository.user

import com.github.edwnmrtnz.posko.data.model.User

interface UserDataSource {

    interface AuthenticateUserCallback {
        fun onAuthenticated(user: User)
        fun onFailed(message : String, statusCode : Int)
    }

    fun authenticateUser(account_name : String, email : String, password : String, callback: AuthenticateUserCallback)

    fun saveUser(user : User)
}