package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.api.model.ProductWithVariantsRaw
import com.google.gson.*
import java.lang.reflect.Type

class ProductsDeserializer : JsonDeserializer<List<ProductRaw>> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): List<ProductRaw> {
        val jsonObject : JsonObject = json.asJsonObject

        val products = jsonObject.getAsJsonArray("products")

        val productsList = ArrayList<ProductRaw>()

        for(item in products) {
            productsList.add(context.deserialize(item, ProductWithVariantsRaw::class.java))
        }
        return productsList
    }
}