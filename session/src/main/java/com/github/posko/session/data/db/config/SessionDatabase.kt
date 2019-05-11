package com.github.posko.session.data.db.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.posko.session.data.db.dao.SessionDao
import com.github.posko.session.data.db.model.SessionData

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
            SessionDatabase.getDatabase(context).clearAllTables()
        }
    }
}