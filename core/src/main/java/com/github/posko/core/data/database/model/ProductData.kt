package com.github.posko.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "variants")
data class ProductData (
        @PrimaryKey var id : Int,
        var account_id : Int,
        var title : String,
        var vendor : String?,
        var product_type : String,
        var handle : String?,
        var status : String,
        var product_status : String?,
        var created_at : Date,
        var updated_at : Date,
        var default_variant_id : Int?

)