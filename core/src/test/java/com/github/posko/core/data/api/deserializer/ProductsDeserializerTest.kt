package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.ProductRaw
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Test

class ProductsDeserializerTest : UnitTest() {

    @Test
    fun `should be able to deserialize index of products`() {
//        val listType = object : TypeToken<List<ProductRaw>>() {}.type
//        val gson = GsonBuilder()
//                .setPrettyPrinting()
//                .registerTypeAdapter(listType, ProductsDeserializer())
//                .create()
//
//        val variants : List<ProductRaw> = gson.fromJson(
//                readFile("stubs/variants.txt"), listType
//        )
//
//        assertNotNull(variants)
//
//   //x     assertEquals(3, variants.size)
//
//        doPrint(variants)
    }
}