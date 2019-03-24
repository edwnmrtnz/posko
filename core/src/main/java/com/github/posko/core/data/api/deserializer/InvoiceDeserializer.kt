package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.InvoiceRaw
import com.google.gson.*
import java.lang.reflect.Type

class InvoiceDeserializer : JsonDeserializer<InvoiceRaw> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): InvoiceRaw {
        val jsonObject : JsonObject = json.asJsonObject

        val invoice = jsonObject.getAsJsonObject("invoice")

        return Gson().fromJson(invoice, InvoiceRaw::class.java)
    }
}