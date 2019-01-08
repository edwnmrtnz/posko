package com.github.posko.core.domain.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatchers {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}