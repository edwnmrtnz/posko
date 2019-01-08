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
//        val products : List<ProductRaw> = gson.fromJson(
//                readFile("stubs/products.txt"), listType
//        )
//
//        assertNotNull(products)
//
//   //x     assertEquals(3, products.size)
//
//        doPrint(products)
    }
}