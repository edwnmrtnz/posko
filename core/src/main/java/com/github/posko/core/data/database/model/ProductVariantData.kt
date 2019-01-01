package com.github.posko.core.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_variants")
class ProductVariantData (

        @PrimaryKey
        var id : Int,

        @ColumnInfo(name = "product_id")
        var productId : Int,

        @ColumnInfo(name = "parent_product_id")
        var parentProductId : Int?,

        @ColumnInfo(name = "parent_variant_id")
        var parentVariantId : Int?,

        var title : String,
        var sku : String?,
        var price : Double,

        @ColumnInfo(name = "compare_at_price")
        var compareAtPrice: Double?,

        var barcode: String?,

        @ColumnInfo(name = "variant_type")
        var variantType : String,

        @ColumnInfo(name = "variant_status")
        var variantStatus: Int?,

        var status : String,

        @ColumnInfo(name = "created_at")
        var createdAt : String,

        @ColumnInfo(name = "updated_at")
        var updatedAt : String,

        @ColumnInfo(name = "selling_policy")
        var sellingPolicy : String,

        var cost: Double?,

        @ColumnInfo(name = "open_price")
        var openPrice: Boolean?
)