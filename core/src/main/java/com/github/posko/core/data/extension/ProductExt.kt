package com.github.posko.core.data.extension

import android.annotation.SuppressLint
import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.database.model.ProductData
import com.github.posko.core.domain.model.Product
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun ProductRaw.toDomain() : Product {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return Product (
            id,
            account_id,
            title,
            vendor,
            product_type,
            handle,
            status,
            product_status,
            formatter.parse(created_at),
            formatter.parse(updated_at),
            default_variant_id
    )
}

fun Product.toDatabase() : ProductData {
    return ProductData (
            id,
            accountId,
            title,
            vendor,
            productType,
            handle,
            status,
            productStatus,
            createdAt,
            updatedAt,
            defaultVariantId
    )
}