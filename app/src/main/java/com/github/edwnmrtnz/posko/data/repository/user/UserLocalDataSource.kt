package com.github.edwnmrtnz.posko.data.repository.user

class UserLocalDataSource : UserDataSource {

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {
        //Implementation goes to remote data source
    }
}