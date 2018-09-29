package com.github.posko.core

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object AssetReader {

    fun readJsonFile(filenameWithExtension: String): String {
        try {
            val br = BufferedReader(InputStreamReader(FileInputStream("../core/src/main/assets/$filenameWithExtension")))
            val sb = StringBuilder()

            var line: String? = br.readLine()
            while (line != null) {
                sb.append(line)
                line = br.readLine()
            }
            return sb.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            throw IllegalStateException(e.message)
        }

    }
}
