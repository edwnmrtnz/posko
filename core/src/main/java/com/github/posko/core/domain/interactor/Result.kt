package com.github.posko.core.domain.interactor

import java.lang.Exception

sealed class Result<out T: Any> {

    data class Success<out T : Any>(val data : T) : Result<T>()

    data class Error(var code : Int, var exception: Exception) : Result<Nothing>()

}