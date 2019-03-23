package com.github.posko.core.domain.model

data class TicketLine (
        val ticketNumber : Int,
        val variantId : Int,
        var productId : Int,
        var price : Double,
        var title : String,
        var quantity : Int
)