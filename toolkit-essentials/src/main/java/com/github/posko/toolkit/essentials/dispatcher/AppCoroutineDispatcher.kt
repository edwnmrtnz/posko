package com.github.posko.toolkit.essentials.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}