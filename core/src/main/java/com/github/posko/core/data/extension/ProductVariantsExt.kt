package com.github.posko.core.data.extension

import com.github.posko.core.data.api.model.ProductVariantRaw
import com.github.posko.core.domain.model.ProductVariant

fun ProductVariantRaw.toProductVariant() : ProductVariant {
    return ProductVariant(id,
            product_id,
            parent_product_id,
            parent_variant_id,
            title,
            sku,
            price,
            compare_at_price,
            barcode,
            variant_type,
            variant_status,
            status,
            created_at,
            updated_at,
            selling_policy,
            cost,
            open_price)
}