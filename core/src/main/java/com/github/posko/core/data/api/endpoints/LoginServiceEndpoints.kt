package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.UserRaw
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginServiceEndpoints {

    @FormUrlEncoded
    @POST("/api/v1/sign_in")
    fun login(@Field("account_name") name : String,
              @Field("email") email : String,
              @Field("password") password : String) : Call<UserRaw>
}