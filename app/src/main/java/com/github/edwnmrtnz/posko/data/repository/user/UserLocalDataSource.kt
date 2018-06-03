package com.github.edwnmrtnz.posko.data.repository.user

import com.github.edwnmrtnz.posko.data.database.dao.UserDao
import com.github.edwnmrtnz.posko.data.model.User

class UserLocalDataSource(private val dao : UserDao) : UserDataSource {

    override fun saveUser(user: User) {
        dao.insert(user)
    }

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {
        //Implementation goes to remote data source
    }
}