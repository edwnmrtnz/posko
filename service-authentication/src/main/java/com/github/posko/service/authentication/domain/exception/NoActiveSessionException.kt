package com.github.posko.service.authentication.domain.exception

import com.github.posko.base.service.exception.PoskoException

class NoActiveSessionException : PoskoException("No active session found")