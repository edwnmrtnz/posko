package com.github.posko.core.data.database.dao

import androidx.room.Dao
import com.github.posko.core.data.database.dao.base.BaseDao
import com.github.posko.core.data.database.model.ProductVariantData

@Dao
interface ProductVariantDao : BaseDao<ProductVariantData> {

}
