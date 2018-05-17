package com.github.edwnmrtnz.poskocore.data.retrofit

class RetrofitHelper {
    companion object {
        @JvmStatic
        var INSTANCE : RetrofitHelper? = null

        @JvmStatic
        fun newInstance(){
            if(INSTANCE == null)
                INSTANCE = RetrofitHelper()
        }

        @JvmStatic
        fun getInstance() : RetrofitHelper {
            if(INSTANCE == null) throw NullPointerException("Please call RetrofitClient.newInstance()")
            else return INSTANCE as RetrofitHelper
        }

        @JvmStatic
        fun destroyInstance() {
            if(INSTANCE != null) INSTANCE = null
        }
    }
}