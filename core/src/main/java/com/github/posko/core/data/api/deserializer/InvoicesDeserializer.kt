package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.InvoiceRaw
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class InvoicesDeserializer : JsonDeserializer<List<InvoiceRaw>> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): List<InvoiceRaw> {
        val jsonObject = json.asJsonObject

        val invoices = jsonObject.getAsJsonArray("invoices")

        val invoicesList = ArrayList<InvoiceRaw>()

        for(item in invoices) {
            invoicesList.add(context.deserialize(item, InvoiceRaw::class.java))
        }

        return invoicesList
    }
}