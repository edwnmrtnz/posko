package com.github.posko.core.data.api.serializer

import com.github.posko.core.UnitTest
import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.forms.InvoiceLineForm
import com.google.gson.GsonBuilder
import org.junit.Test

class InvoiceSerializerTest : UnitTest() {

    @Test
    fun `should be able to serialize invoice form`()  {
        val gson = GsonBuilder()
                .registerTypeAdapter(InvoiceForm::class.java, CreateInvoiceSerializer())
                .setPrettyPrinting()
                .create()

        val invoiceForm = InvoiceForm(
                100,
                mutableListOf(InvoiceLineForm(10,10, 10.0, "test", 1))
        )

        doPrint(gson.toJsonTree(invoiceForm))

    }
}