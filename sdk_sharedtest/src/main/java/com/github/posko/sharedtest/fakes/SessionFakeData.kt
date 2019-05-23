package com.github.posko.sharedtest.fakes

import com.github.posko.sharedtest.helpers.TestAssetReader

class SessionFakeData {
    companion object {
        fun getUser() : String {
            return TestAssetReader.readJsonFile("sign_in.txt")
        }
    }
}