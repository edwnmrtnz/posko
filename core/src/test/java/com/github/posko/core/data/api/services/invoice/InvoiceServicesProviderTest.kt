package com.github.posko.core.data.api.services.invoice

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfigProvider
import com.github.posko.core.data.api.generator.Encryptor
import com.github.posko.core.data.api.generator.ServiceLogger
import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.core.domain.forms.InvoiceLineForm
import com.github.posko.shared.exception.ServiceException
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class InvoiceServicesProviderTest : UnitTest() {

    private lateinit var server : MockWebServer

    @Mock
    private lateinit var encryptor : Encryptor
    private lateinit var logger : ServiceLogger

    @Mock
    private lateinit var authorization: RequestAuthorization
    private lateinit var invoiceServices : InvoiceServicesProvider
    private lateinit var serviceConfigProvider: ServiceConfigProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        logger = Mockito.spy(ServiceLogger::class.java)

        server = MockWebServer()
        server.start()

        Mockito.`when`(encryptor.basicAuthentication(Mockito.anyString(), Mockito.anyString())).thenReturn("")
        Mockito.doNothing().`when`(logger).log(Mockito.anyString(), Mockito.anyString())

        serviceConfigProvider = ServiceConfigProvider(encryptor, logger)

        Mockito.`when`(authorization.getUsername()).thenReturn("")
        Mockito.`when`(authorization.getPassword()).thenReturn("")
        Mockito.`when`(authorization.getDomain()).thenReturn(server.url("/api/v1/invoices/").toString())

        invoiceServices = InvoiceServicesProvider(authorization, serviceConfigProvider)
    }

    @After
    fun destroy() {
        server.shutdown()
    }

    @Test
    fun `should return a valid invoice after sending an invoice form`()= runBlocking {
        val invoiceForm = InvoiceForm(
                100,
                mutableListOf(InvoiceLineForm(10,10, 10.0, "test", 1))
        )

        val json = AssetReader.readJsonFile("stubs/send_invoice_response.txt")

        server.enqueue(MockResponse().setBody(json).setResponseCode(200))
        val invoice = invoiceServices.createInvoice(invoiceForm)

        assertEquals("The id should be 1", 1, invoice.id)
        assertEquals("The invoice number should be 1", 1, invoice.invoice_number)

        doPrint(invoice)
    }

}