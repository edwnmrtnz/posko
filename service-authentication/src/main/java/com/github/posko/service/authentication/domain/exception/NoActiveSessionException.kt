package com.github.posko.service.authentication.domain.exception

import com.github.posko.core.exception.PoskoException

class NoActiveSessionException : PoskoException("No active session found")