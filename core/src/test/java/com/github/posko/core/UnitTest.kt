package com.github.posko.core

import com.google.gson.GsonBuilder

open class UnitTest {

    protected var gsonBuilder : GsonBuilder = GsonBuilder().setPrettyPrinting()

    protected fun doPrint(any : Any) {
        System.out.println(gsonBuilder.create().toJson(any))
    }

    protected fun readFile(fileNameWithExt: String) : String {
        return AssetReader.readJsonFile(fileNameWithExt)
    }
}