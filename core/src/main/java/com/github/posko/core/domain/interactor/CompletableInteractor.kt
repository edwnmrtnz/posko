package com.github.posko.core.domain.interactor

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch


abstract class CompletableInteractor<in Param>(private val dispatcher: AppCoroutineDispatcher) {

    internal abstract suspend fun run (params : Param) : Either<Failure, Boolean>

    fun execute(params : Param, result : (Either<Failure, Boolean>) -> Unit) {
        val job = async(dispatcher.io()) {
            run(params)
        }

        launch(dispatcher.ui()) {
            result.invoke(job.await())
        }
    }
}