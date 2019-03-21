package com.github.posko.core.domain.model

class Count(private val total: Int) {

    fun pages (limit : Int) : Int {
        return Math.ceil(total/limit.toDouble()).toInt()
    }

}
