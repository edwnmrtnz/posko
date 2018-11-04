package com.github.posko.core.domain.result

sealed class Failure(open var message : String) {
    class HttpFailure(val code : Int, override var message : String) : Failure(message)
    class TransactionFailure(override var message : String) : Failure(message)
}