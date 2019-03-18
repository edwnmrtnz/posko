package com.github.posko.shared.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcherProvider {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}