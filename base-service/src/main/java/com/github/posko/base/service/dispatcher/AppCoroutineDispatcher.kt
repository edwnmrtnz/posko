package com.github.posko.base.service.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {

    fun ui () : CoroutineDispatcher

    fun io () : CoroutineDispatcher
}