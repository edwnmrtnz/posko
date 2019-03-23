package com.github.posko.core.domain.exception

import com.github.posko.shared.exception.PoskoException

class TicketDoesNotExistException(message : String) : PoskoException(message)