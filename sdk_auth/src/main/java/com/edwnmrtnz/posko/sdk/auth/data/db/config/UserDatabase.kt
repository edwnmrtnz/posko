package com.edwnmrtnz.posko.sdk.auth.data.db.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edwnmrtnz.posko.sdk.auth.data.db.dao.UserDao
import com.edwnmrtnz.posko.sdk.auth.data.db.model.UserData

@Database(
        entities = [
            (UserData::class)
        ],
        version = 1,
        exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    abstract val dao : UserDao

    companion object {
        private const val databaseName = "posko_user.db"
        @Volatile private var instance : UserDatabase? = null

        @JvmStatic
        @Synchronized
        fun getDatabase(context: Context) : UserDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(
                        context, UserDatabase::class.java, databaseName)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance!!
        }

        @JvmStatic
        fun destroy(context: Context) {
            getDatabase(context).clearAllTables()
        }
    }
}