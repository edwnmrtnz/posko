package com.github.posko.core.data.api.endpoints

import com.github.posko.core.data.api.model.UserRaw
import kotlinx.coroutines.Deferred

import retrofit2.http.*

interface UserServicesApi {

    @FormUrlEncoded
    @POST("/api/v1/sign_in")
    fun login(@Field("account_name") name : String,
              @Field("email") email : String,
              @Field("password") password : String) : Deferred<UserRaw>
}