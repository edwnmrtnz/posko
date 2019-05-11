package com.github.posko.core.data.api.services.invoice

import com.github.posko.core.data.api.RequestAuthorization
import com.github.posko.core.data.api.config.ServiceConfiguration
import com.github.posko.core.data.api.deserializer.InvoiceDeserializer
import com.github.posko.core.data.api.endpoints.InvoiceServiceEndpoints
import com.github.posko.core.data.api.model.InvoiceRaw
import com.github.posko.core.data.api.serializer.CreateInvoiceSerializer
import com.github.posko.core.domain.forms.InvoiceForm
import com.github.posko.base.exception.HttpErrorException
import com.github.posko.base.exception.ServiceException
import com.google.gson.GsonBuilder
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class InvoiceServicesProvider(private val requestAuthorization: RequestAuthorization,
                              private val config : ServiceConfiguration) : InvoiceServices {

    override suspend fun createInvoice(invoiceForm: InvoiceForm): InvoiceRaw {
        val gson = GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(InvoiceForm::class.java, CreateInvoiceSerializer())
                .registerTypeAdapter(InvoiceRaw::class.java, InvoiceDeserializer())
                .create()

        return suspendCancellableCoroutine {
            config.getConfig()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .setEnableLogging("create_invoice")
                    .setBaseUrl(requestAuthorization.getDomain())
                    .setBasicAuth(requestAuthorization.getUsername(), requestAuthorization.getPassword())
                    .build()
                    .generateService(InvoiceServiceEndpoints::class.java)
                    .createInvoice(invoiceForm)
                    .enqueue(object : Callback<InvoiceRaw> {
                        override fun onFailure(call: Call<InvoiceRaw>, t: Throwable) {
                            it.resumeWithException(ServiceException(t.localizedMessage))
                        }

                        override fun onResponse(call: Call<InvoiceRaw>, response: Response<InvoiceRaw>) {
                            if(response.isSuccessful) {
                                it.resume(response.body()!!)
                            } else {
                                it.resumeWithException(HttpErrorException(response.code(),
                                        response.errorBody()?.string() ?: "Something went wrong"))
                            }
                        }
                    })
        }
    }
}