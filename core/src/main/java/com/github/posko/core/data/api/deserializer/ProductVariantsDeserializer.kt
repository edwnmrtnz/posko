package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.ProductVariantRaw
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ProductVariantsDeserializer : JsonDeserializer<List<ProductVariantRaw>> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): List<ProductVariantRaw> {
        val jsonObject = json.asJsonObject

        val variants = jsonObject.getAsJsonArray("variants")

        val variantsList = ArrayList<ProductVariantRaw>()

        for(item in variants) {
            variantsList.add(context.deserialize(item, ProductVariantRaw::class.java))
        }
        return variantsList
    }
}