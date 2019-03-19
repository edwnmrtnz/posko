package com.github.posko.core.domain.model

import java.util.*

data class ProductVariant (
        var id : Int,
        var productId : Int,
        var parentProductId : Int?,
        var parentVariantId : Int?,
        var sku : String,
        var price : Double,
        var compareAtPrice: Double?,
        var barcode : String,
        var variantType : String?,
        var variantStatus : Int?,
        var status : String,
        var createdAt : Date,
        var updatedAt : Date,
        var sellingPolicy : String,
        var cost : Double?,
        var openPrice : Double,
        var default : Boolean
)