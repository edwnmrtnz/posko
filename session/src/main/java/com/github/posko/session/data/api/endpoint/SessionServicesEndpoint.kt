package com.github.posko.session.data.api.endpoint

import com.github.posko.session.data.api.model.UserRaw
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SessionServicesEndpoint {

    @POST("/sign_in")
    @FormUrlEncoded
    fun signIn(@Field("account_name") accountName : String,
               @Field("email") email : String,
               @Field("password") password : String) : Call<UserRaw>


    @DELETE("/sign_out")
    fun signOut() : Call<String>

}