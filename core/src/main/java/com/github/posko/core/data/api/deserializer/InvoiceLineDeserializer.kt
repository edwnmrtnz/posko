package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.InvoiceLineRaw
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class InvoiceLineDeserializer : JsonDeserializer<List<InvoiceLineRaw>> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): List<InvoiceLineRaw> {
        val jsonObject = json.asJsonObject

        val invoiceLines = jsonObject.getAsJsonArray("invoice_lines")

        val invoiceLinesList = ArrayList<InvoiceLineRaw>()

        for(item in invoiceLines) {
            invoiceLinesList.add(context.deserialize(item, InvoiceLineRaw::class.java))
        }
        return invoiceLinesList
    }
}