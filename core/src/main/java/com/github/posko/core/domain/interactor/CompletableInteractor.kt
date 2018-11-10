package com.github.posko.core.domain.interactor

import com.github.posko.core.domain.dispatcher.AppCoroutineDispatcher
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

abstract class CompletableInteractor<in Param>(private val dispatcher: AppCoroutineDispatcher) {

    internal abstract suspend fun run (params : Param)

    fun execute(params : Param) {
        val job = async(dispatcher.io()) {
            run(params)
        }
    }
}