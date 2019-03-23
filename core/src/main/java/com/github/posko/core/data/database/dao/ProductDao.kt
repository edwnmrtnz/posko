package com.github.posko.core.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.github.posko.core.data.database.dao.base.BaseDao
import com.github.posko.core.data.database.model.ProductData
import com.github.posko.core.domain.model.Product

@Dao
interface ProductDao : BaseDao<ProductData> {

    @Query("SELECT id FROM products ORDER BY updated_at DESC LIMIT 1")
    fun getLastRecordedId() : Int?
}