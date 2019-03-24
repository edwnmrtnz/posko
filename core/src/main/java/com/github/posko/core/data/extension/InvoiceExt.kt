package com.github.posko.core.data.extension

import android.annotation.SuppressLint
import com.github.posko.core.data.api.model.InvoiceRaw
import com.github.posko.core.domain.model.Invoice
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun InvoiceRaw.toDomain() : Invoice {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return Invoice (
            id,
            account_id,
            user_id,
            invoice_number,
            note,
            total_line_items_price,
            total_discounts,
            subtotal,
            total_price,
            total_tax,
            total_weight,
            first_name,
            middle_name,
            last_name,
            email,
            contact_number,
            suffix,
            fulfillment_status,
            invoice_status,
            status,
            formatter.parse(created_at),
            formatter.parse(updated_at)
    )
}