package com.github.posko.core.domain.model

class TicketWithLines (val ticket : Ticket,
                       var ticketLine : MutableList<TicketLine>)