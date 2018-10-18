package com.github.posko.core.domain.model

data class TicketLine(var productId : Int,
                      var variantId : Int,
                      var price : Int,
                      var title : String?,
                      var quantity : Int)