package com.github.posko.core.domain.result

sealed class Error(open var message : String) {
    class HttpError(val code : Int, override var message : String) : Error(message)
    class TransactionError(override var message : String) : Error(message)
}