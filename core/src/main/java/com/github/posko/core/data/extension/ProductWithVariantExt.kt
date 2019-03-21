package com.github.posko.core.data.extension

import android.annotation.SuppressLint
import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import com.github.posko.core.domain.model.Product
import com.github.posko.core.domain.model.ProductWithVariant
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun ProductWithVariantsRaw.toDomain() : ProductWithVariant{
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val product = Product(id, account_id, title, vendor,
            handle, product_type, status,
            product_status, formatter.parse(created_at), formatter.parse(updated_at),
            default_variant_id)
    return ProductWithVariant(product, variants.map { it.toDomain() }.toMutableList())
}