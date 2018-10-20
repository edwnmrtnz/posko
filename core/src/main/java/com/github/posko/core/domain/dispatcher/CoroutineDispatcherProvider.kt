package com.github.posko.core.domain.dispatcher

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

class CoroutineDispatcherProvider : AppCoroutineDispatcher {

    override fun ui(): CoroutineContext = UI

    override fun io(): CoroutineContext = CommonPool
}