package com.github.posko.service.authentication.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: T)

    @Insert
    fun insert(vararg elements: T)

    @Delete
    fun delete(element: T)

    @Update
    fun update(element: T)
}