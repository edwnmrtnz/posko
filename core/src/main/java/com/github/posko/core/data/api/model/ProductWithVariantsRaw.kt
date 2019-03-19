package com.github.posko.core.data.api.model

data class ProductWithVariantsRaw (
        var id : Int,
        var account_id : Int,
        var title : String,
        var vendor : String?,
        var product_type : String,
        var handle : String,
        var status : String,
        var product_status : String,
        var created_at : String,
        var updated_at : String,
        var default_variant_id : Int?,
        var variants : MutableList<ProductVariantRaw>
)