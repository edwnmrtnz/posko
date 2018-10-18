package com.github.posko.core.domain.model

data class Ticket(var customerId: Int,
                  var invoiceNumber : Int,
                  var subtotal : Double,
                  var ticketLines : MutableList<TicketLine>)