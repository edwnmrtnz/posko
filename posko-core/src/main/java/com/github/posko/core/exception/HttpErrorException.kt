package com.github.posko.core.exception

/**
 * Created by edwin on 10/03/2018.
 */
class HttpErrorException (
    code : Int,
    message : String
) : PoskoException(message)