package com.github.posko.shared.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}