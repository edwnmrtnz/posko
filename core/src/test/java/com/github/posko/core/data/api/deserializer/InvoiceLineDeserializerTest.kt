package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.InvoiceLineRaw
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Test

class InvoiceLineDeserializerTest : UnitTest() {

    @Test
    fun `should be able to deserialize invoice lines for specific invoice` () {
        val listype = object : TypeToken<MutableList<InvoiceLineRaw>>() {}.type
        val gson = gsonBuilder
                .registerTypeAdapter(listype, InvoiceLineDeserializer())
                .create()

        val invoiceLines : List<InvoiceLineRaw> =
                gson.fromJson(AssetReader.readJsonFile("stubs/invoice_lines.txt"), listype)

        assertNotNull(invoiceLines)

        assertEquals(2, invoiceLines.size)

        doPrint(invoiceLines)
    }
}