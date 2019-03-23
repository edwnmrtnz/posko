package com.github.posko.core.domain.forms

class InvoiceLineForm (
        val variantId : Int,
        var productId : Int,
        var price : Double,
        var title : String,
        var quantity : Int
)

