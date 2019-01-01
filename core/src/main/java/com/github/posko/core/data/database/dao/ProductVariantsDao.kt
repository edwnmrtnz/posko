package com.github.posko.core.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.github.posko.core.data.database.dao.base.BaseDao
import com.github.posko.core.data.database.model.ProductVariantData

@Dao
interface ProductVariantsDao : BaseDao<ProductVariantData> {

    @Query("SELECT * FROM product_variants")
    fun getVariants() : MutableList<ProductVariantData>
}