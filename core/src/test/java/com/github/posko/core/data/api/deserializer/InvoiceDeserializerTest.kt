package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.InvoiceRaw
import com.github.posko.core.data.api.model.ProductRaw
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Test

class InvoiceDeserializerTest : UnitTest() {

    @Test
    fun `should be able to deserialize index of invoice`() {
        val listType = object : TypeToken<MutableList<InvoiceRaw>>() {}.type
        val gson = GsonBuilder()
                .registerTypeAdapter(listType, InvoiceDeserializer())
                .create()

        val invoices : List<InvoiceRaw> = gson.fromJson(readFile("/stubs/invoices.txt"), listType)

        assertNotNull(invoices)

        assertEquals(3, invoices.size)

        doPrint(invoices)
    }
}