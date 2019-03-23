package com.github.posko.core.domain.gateways

import com.github.posko.core.domain.model.TicketLine

interface TicketLineGateway {

    suspend fun save(ticketLine: TicketLine)

    suspend fun save(ticketLines : MutableList<TicketLine>)

}