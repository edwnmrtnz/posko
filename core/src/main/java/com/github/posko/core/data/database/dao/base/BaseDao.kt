package com.github.posko.core.data.database.dao.base

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element : T)

    @Insert
    fun insert(vararg elements : T)

    @Delete
    fun delete(element : T)

    @Update
    fun update(element : T)
}