package com.github.posko.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "product_variants")
class ProductVariantData (
        @PrimaryKey var id : Int,
        var product_id : Int,
        var parent_product_id : Int?,
        var parent_variant_id : Int?,
        var sku : String,
        var price : Double,
        var compare_at_price: Double?,
        var barcode: String?,
        var variant_type : String?,
        var variant_status: Int?,
        var status : String,
        var created_at : Date,
        var updated_at : Date,
        var selling_policy : String,
        var cost: Double?,
        var open_price: Boolean?,
        var default : Boolean?
)
