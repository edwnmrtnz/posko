package com.github.posko.sharedtest.helpers

import com.github.posko.toolkit.essentials.dispatcher.AppCoroutineDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestCoroutineDispatcherProvider : AppCoroutineDispatcher {
    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Default

    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}