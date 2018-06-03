package com.github.edwnmrtnz.posko.data.repository.user

import com.github.edwnmrtnz.posko.data.model.User

class UserRepository(private val userLocalDataSource: UserDataSource,
                     private val userRemoteDataSource: UserDataSource) : UserDataSource {

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {

        userRemoteDataSource.authenticateUser(account_name, email, password, object : UserDataSource.AuthenticateUserCallback {

            override fun onAuthenticated(user: User) {
                saveUser(user)
                callback.onAuthenticated(user)
            }

            override fun onFailed(message: String, statusCode: Int) {
                callback.onFailed(message, statusCode)
            }
        })
    }

    override fun saveUser(user: User) {
        userLocalDataSource.saveUser(user)
    }

    companion object {
        private var INSTANCE: UserRepository? = null

        @JvmStatic fun getInstance(userLocalDataSource: UserDataSource, userRemoteDataSource: UserDataSource): UserRepository {
            return INSTANCE ?: UserRepository(userLocalDataSource, userRemoteDataSource).apply { INSTANCE = this }
        }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }

    }

}
