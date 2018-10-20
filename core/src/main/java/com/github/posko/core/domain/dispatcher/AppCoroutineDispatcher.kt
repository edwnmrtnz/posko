package com.github.posko.core.domain.dispatcher

import kotlin.coroutines.experimental.CoroutineContext

interface AppCoroutineDispatcher {

    fun ui() : CoroutineContext

    fun io() : CoroutineContext

}