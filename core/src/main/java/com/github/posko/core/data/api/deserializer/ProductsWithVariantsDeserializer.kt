package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class ProductsWithVariantsDeserializer : JsonDeserializer<List<ProductWithVariantsRaw>> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): List<ProductWithVariantsRaw> {
        val jsonObject : JsonObject = json.asJsonObject
        val products = jsonObject.getAsJsonArray("products")

        val productsWithVariantsList = ArrayList<ProductWithVariantsRaw>()

        for(item in products) {
            productsWithVariantsList.add(context.deserialize(item, ProductWithVariantsRaw::class.java))
        }
        return productsWithVariantsList
    }
}