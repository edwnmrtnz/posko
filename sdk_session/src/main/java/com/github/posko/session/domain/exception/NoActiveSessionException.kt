package com.github.posko.session.domain.exception

import com.github.posko.base.exception.PoskoException

class NoActiveSessionException  : PoskoException("No active session found")