package com.github.posko.toolkit.essentials.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class AppCoroutineDispatcherProvider : AppCoroutineDispatcher {

    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}