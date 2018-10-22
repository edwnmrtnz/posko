package com.github.posko.core.domain.interactor

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Error
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

abstract class Interactor<out Response, in Request> (private val dispatcher : AppCoroutineDispatcher) where Response : Any {

    internal abstract suspend fun run (params : Request) : Either<Error, Response>

    fun execute(params : Request, result : (Either<Error, Response>) -> Unit) {
        val job = async(dispatcher.io()) {
            run(params)
        }
        launch(dispatcher.ui()) {
            result.invoke(job.await())
        }
    }
}