package com.github.edwnmrtnz.posko.data.database.dao

import android.arch.persistence.room.Dao
import com.github.edwnmrtnz.posko.data.database.BaseDao
import com.github.edwnmrtnz.posko.data.model.User

@Dao
interface UserDao : BaseDao <User> {

}