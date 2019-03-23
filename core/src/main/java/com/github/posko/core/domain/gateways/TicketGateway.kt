package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.Ticket
import com.github.posko.core.domain.model.TicketWithLines

interface TicketGateway {

    suspend fun create(ticket: Ticket)

    suspend fun get(ticketNumber : Int) : Ticket

    suspend fun get() : MutableList<Ticket>

    suspend fun getTicketsWithLines() : MutableList<TicketWithLines>

    suspend fun getTicketWithLines(ticketNumber : Int) : TicketWithLines
}