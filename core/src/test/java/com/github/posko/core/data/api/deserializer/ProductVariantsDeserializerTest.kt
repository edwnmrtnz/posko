package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.ProductRaw
import com.github.posko.core.data.api.model.ProductVariantRaw
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Test

class ProductVariantsDeserializerTest : UnitTest() {
    @Test
    fun `should be able to deserialize product variants`() {
//        val listType = object : TypeToken<List<ProductVariantRaw>>() {}.type
//        val gson = GsonBuilder()
//                .setPrettyPrinting()
//                .registerTypeAdapter(listType, ProductVariantsDeserializer())
//                .create()
//
//        val variants : List<ProductVariantRaw> = gson.fromJson(
//                readFile("stubs/product_variants.txt"), listType
//        )
//
//        assertNotNull(variants)
//
//        assertEquals(2, variants.size)
    }
}