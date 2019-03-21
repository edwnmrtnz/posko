package com.github.posko.core.data.extension

import android.annotation.SuppressLint
import com.github.posko.core.data.api.model.ProductVariantRaw
import com.github.posko.core.data.database.model.ProductVariantData
import com.github.posko.core.domain.model.ProductVariant
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun ProductVariantRaw.toDomain() : ProductVariant {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return ProductVariant (
            id,
            product_id,
            parent_product_id,
            parent_variant_id,
            sku,
            price,
            compare_at_price,
            barcode,
            variant_type,
            variant_status,
            status,
            formatter.parse(created_at),
            formatter.parse(updated_at),
            selling_policy,
            cost,
            open_price,
            default
    )
}

fun ProductVariant.toDatabase() : ProductVariantData {
    return ProductVariantData (
            id,
            productId,
            parentProductId,
            parentVariantId,
            sku,
            price,
            compareAtPrice,
            barcode,
            variantType,
            variantStatus,
            status,
            createdAt,
            updatedAt,
            sellingPolicy,
            cost,
            openPrice,
            default
    )
}