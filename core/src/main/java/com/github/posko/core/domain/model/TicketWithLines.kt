package com.github.posko.core.domain.model

class TicketWithLines (var ticket : Ticket,
                       var ticketLines : MutableList<TicketLine>)