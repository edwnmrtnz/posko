package com.github.posko.core.exception

/**
 * Created by edwin on 10/03/2018.
 */
class PoskoServiceFailureException(
    message : String,
    throwable: Throwable
) : PoskoException(message)