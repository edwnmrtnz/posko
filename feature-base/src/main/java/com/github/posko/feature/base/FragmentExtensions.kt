package com.github.posko.feature.base

import androidx.fragment.app.Fragment

/**
 * Created by edwinmartinez on June 20, 2019
 */

fun Fragment.delay(millis : Long, block: () -> Unit) {
    val timer = object : Thread() {
        override fun run() {
            try {
                sleep(millis)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                block.invoke()
            }
        }
    }
    timer.start()
}