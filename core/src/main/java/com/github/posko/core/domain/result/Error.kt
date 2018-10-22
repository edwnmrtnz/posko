package com.github.posko.core.domain.result

sealed class Error {
    class HttpError(val code : Int, val message : String) : Error()
    class TransactionError(val message : String) : Error()
}