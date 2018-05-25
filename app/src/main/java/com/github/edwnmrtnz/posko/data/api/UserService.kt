package com.github.edwnmrtnz.posko.data.api

import com.github.edwnmrtnz.posko.data.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {

    @POST("/api/v1/sign_in")
    @Headers("Accept: application/json")
    @FormUrlEncoded
    fun authenticateUser(@Field("account_name") account_name: String,
                         @Field("email") email : String,
                         @Field("password") password: String ) : Call<User>

}