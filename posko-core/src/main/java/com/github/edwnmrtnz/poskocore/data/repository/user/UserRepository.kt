package com.github.edwnmrtnz.poskocore.data.repository.user

class UserRepository(val userLocalDataSource: UserLocalDataSource, val userRemoteDataSource: UserRemoteDataSource) : UserDataSource {
    companion object {
        val TAG = "UserRepository"
    }

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {
        userRemoteDataSource.authenticateUser(account_name, email, password, callback)
    }

}