package com.github.posko.core

import com.google.gson.GsonBuilder

open class UnitTest {

    protected fun doPrint(any : Any) {
        System.out.println(GsonBuilder().setPrettyPrinting().create().toJson(any))
    }
}