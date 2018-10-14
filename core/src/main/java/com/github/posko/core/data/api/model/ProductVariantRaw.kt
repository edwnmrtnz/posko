package com.github.posko.core.data.api.model

data class ProductVariantRaw(var id : Int,
                             var product_id : Int,
                             var parent_product_id : Int?,
                             var parent_variant_id : Int?,
                             var title : String,
                             var sku : String?,
                             var price : Double,
                             var compare_at_price: Double,
                             var barcode: String?,
                             var variant_type : String,
                             var variant_status: Int?,
                             var status : String,
                             var created_at : String,
                             var updated_at : String,
                             var selling_policy : String,
                             var cost: Double?)