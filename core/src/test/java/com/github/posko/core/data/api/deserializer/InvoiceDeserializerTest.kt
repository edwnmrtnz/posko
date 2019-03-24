package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.InvoiceRaw
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test

class InvoiceDeserializerTest : UnitTest() {

    @Test
    fun `should be able to deserialize invoice`()  {

        val raw = AssetReader.readJsonFile("stubs/send_invoice_response.txt")

        val gson = GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(InvoiceRaw::class.java, InvoiceDeserializer())
                .create()

        val invoice = gson.fromJson(raw, InvoiceRaw::class.java)

        Assert.assertEquals("id should be equal", 1, invoice.id)
        Assert.assertEquals("account_id should be equal", 2, invoice.account_id)

    }


}