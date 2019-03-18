package com.github.posko.shared.interactor

import kotlinx.coroutines.*
import com.github.posko.shared.dispatcher.AppCoroutineDispatcherProvider
import java.lang.Exception
import java.lang.IllegalStateException
import java.lang.NullPointerException
import java.sql.SQLException

abstract class UseCase<out R, in P> (private val dispatcherProvider: AppCoroutineDispatcherProvider) {

    private val job = SupervisorJob()

    private val scope : CoroutineScope = CoroutineScope(dispatcherProvider.io() + job)


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
            withContext(dispatcherProvider.ui()) {
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