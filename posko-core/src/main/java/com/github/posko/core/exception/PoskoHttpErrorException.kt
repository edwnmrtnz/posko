package com.github.posko.core.exception

/**
 * Created by edwin on 10/03/2018.
 */
class PoskoHttpErrorException (
    code : Int,
    message : String
) : PoskoException(message)