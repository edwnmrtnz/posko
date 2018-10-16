package com.github.posko.core.data.api.model

data class InvoiceLineRaw(var id: Int,
                          var invoice: Int,
                          var variant_id : Int,
                          var product_id : Int,
                          var title: String?,
                          var sku : String?,
                          var price : Double,
                          var compare_at_price : Double?,
                          var barcode : String?,
                          var invoice_line_status : Int?,
                          var status : String,
                          var created_at : String,
                          var updated_at : String,
                          var quantity : Double,
                          var weight : Double)