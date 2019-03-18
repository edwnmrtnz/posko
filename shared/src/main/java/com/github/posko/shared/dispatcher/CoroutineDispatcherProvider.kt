package com.github.posko.shared.dispatcher

import com.github.posko.shared.dispatcher.AppCoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class CoroutineDispatcherProvider : AppCoroutineDispatcherProvider {

    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}