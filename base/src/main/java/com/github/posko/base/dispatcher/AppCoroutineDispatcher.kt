package com.github.posko.base.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}