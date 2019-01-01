package com.github.posko.core.domain.model

import androidx.room.ColumnInfo

data class ProductVariant(

        var id : Int,

        var productId : Int,

        var parentProductId : Int?,

        var parentVariantId : Int?,

        var title : String,

        var sku : String?,

        var price : Double,

        var compareAtPrice: Double?,

        var barcode: String?,

        var variantType : String,

        var variantStatus: Int?,

        var status : String,

        var createdAt : String,

        var updatedAt : String,

        var sellingPolicy : String,

        var cost: Double?,

        var openPrice: Boolean?
)