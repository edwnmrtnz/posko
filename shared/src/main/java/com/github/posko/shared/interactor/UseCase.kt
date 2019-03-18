package com.github.posko.shared.interactor

import kotlinx.coroutines.*
import com.github.posko.shared.dispatcher.AppCoroutineDispatcher
import java.lang.Exception
import java.lang.IllegalStateException
import java.lang.NullPointerException
import java.sql.SQLException

abstract class UseCase<out R, in P> (private val dispatcher: AppCoroutineDispatcher) {

    private val job = SupervisorJob()

    private val scope : CoroutineScope = CoroutineScope(dispatcher.io() + job)


    abstract suspend fun start(param : P) : R

    //Use this method when in other use cases
    suspend fun execute(param : P) : R {
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
            withContext(dispatcher.ui()) {
                try {
                    results(Result.Success(data.await()))
                } catch (e: Exception) {
                    e.printStackTrace()
                    when (e) {
                        is IllegalStateException -> {
                            throw e
                        }
                        is NullPointerException -> {
                            throw e
                        }
                        is SQLException -> {
                            throw e
                        }
                        is ArrayIndexOutOfBoundsException -> {
                            throw e
                        }
                        else -> {
                            results(Result.Error(e))
                        }
                    }
                }
            }
        }
    }

    fun cancel() {
        scope.coroutineContext.cancel()
    }


}