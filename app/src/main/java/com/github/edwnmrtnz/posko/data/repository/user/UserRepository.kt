package com.github.edwnmrtnz.posko.data.repository.user

class UserRepository(val userLocalDataSource: UserDataSource,
                     val userRemoteDataSource: UserDataSource) : UserDataSource {

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {
        userRemoteDataSource.authenticateUser(account_name, email, password, callback)
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
