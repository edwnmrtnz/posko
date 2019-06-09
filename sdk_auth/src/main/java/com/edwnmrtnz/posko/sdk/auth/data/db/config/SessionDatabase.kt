package com.edwnmrtnz.posko.sdk.auth.data.db.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edwnmrtnz.posko.sdk.auth.data.db.dao.SessionDao
import com.edwnmrtnz.posko.sdk.auth.data.db.model.SessionData

@Database(
        entities = [
            (SessionData::class)
        ],
        version = 1,
        exportSchema = false
)
abstract class SessionDatabase : RoomDatabase() {

    abstract val dao : SessionDao

    companion object {
        private const val databaseName = "posko_session.db"
        @Volatile private var instance : SessionDatabase? = null

        @JvmStatic
        @Synchronized
        fun getDatabase(context : Context) : SessionDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(
                        context, SessionDatabase::class.java, databaseName)
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