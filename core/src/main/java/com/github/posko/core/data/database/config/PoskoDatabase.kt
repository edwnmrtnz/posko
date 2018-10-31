package com.github.posko.core.data.database.config


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.posko.core.data.database.dao.SessionDao
import com.github.posko.core.data.database.dao.UserDao
import com.github.posko.core.data.database.model.SessionData
import com.github.posko.core.data.database.model.UserData

@Database(
        entities = [
            (UserData::class),
            (SessionData::class)
        ],
        version = 1,
        exportSchema = false
)
abstract class PoskoDatabase : RoomDatabase() {

    abstract val userDao : UserDao
    abstract val sessionDao : SessionDao

    companion object {
        private const val databaseName = "posko"
        @Volatile private var instance : PoskoDatabase? = null

        @JvmStatic
        @Synchronized
        fun getInstance(context: Context) : PoskoDatabase? {
            if(instance == null) {
                instance = Room.databaseBuilder(context, PoskoDatabase::class.java, databaseName)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance
        }

        @JvmStatic
        fun destroy(context: Context) {
            PoskoDatabase.getInstance(context)!!.clearAllTables()
        }
    }
}