package com.github.posko.core.domain.interactor

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatchers
import kotlinx.coroutines.*
import java.lang.Exception

abstract class Interactor<out R, in P> (private val dispatcher: AppCoroutineDispatchers) {

    val job = SupervisorJob()

    private val scope : CoroutineScope = CoroutineScope(dispatcher.io() + job)

    abstract suspend fun start(param : P) : R

    //Use this method when in other use cases
    suspend fun execute(param : P) : R  {
        val data = scope.async {
            start(param)
        }
        return data.await()
    }

    //Use this when consuming in the ui thread
    fun execute(parameters: P, results : (Result<R>) -> Unit) {
        scope.launch {
            val data = scope.async {
                start(parameters)
            }
            try {
                results(Result.Success(data.await()))
            } catch (e: Exception) {
                results(Result.Error(e))
            }
        }
    }

    fun cancel() {
        scope.coroutineContext.cancel()
    }
}