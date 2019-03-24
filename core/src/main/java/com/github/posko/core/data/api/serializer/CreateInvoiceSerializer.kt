package com.github.posko.core.data.api.serializer

import com.github.posko.core.domain.forms.InvoiceForm
import com.google.gson.*
import java.lang.reflect.Type

class CreateInvoiceSerializer : JsonSerializer<InvoiceForm> {
    override fun serialize(src: InvoiceForm, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        val jsonObject = JsonObject()

        val invoice = JsonObject();
        invoice.addProperty("invoice_number", src.invoiceNumber)

        val invoiceLines = JsonArray()

        for (line in src.invoiceLines) {
            val invoiceLine = JsonObject()
            invoiceLine.addProperty("variant_id", line.variantId)
            invoiceLine.addProperty("product_id", line.productId)
            invoiceLine.addProperty("price", line.quantity)
            invoiceLine.addProperty("tital", line.title)
            invoiceLine.addProperty("quantity", line.quantity)
            invoiceLines.add(invoiceLine)
        }

        invoice.add("invoice_lines", invoiceLines)

        jsonObject.add("invoice", invoice)

        return jsonObject
    }
}
