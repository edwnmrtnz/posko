package com.github.edwnmrtnz.posko.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.github.edwnmrtnz.posko.data.database.dao.UserDao
import com.github.edwnmrtnz.posko.data.model.User

@Database(entities = [User::class], version = 1)
abstract class PoskoDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        private var INSTANCE: PoskoDatabase? = null

        private val lock =  Any()

        fun getInstance(context: Context) : PoskoDatabase {
            synchronized(lock){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PoskoDatabase::class.java, "PoskoDb")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}