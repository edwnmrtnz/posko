package com.github.edwnmrtnz.posko.data.repository.user

import com.github.edwnmrtnz.posko.data.api.UserService
import com.github.edwnmrtnz.posko.data.deserializer.UserDeserializer
import com.github.edwnmrtnz.posko.data.model.User
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class UserRemoteDataSource(private val retrofitHelper: RetrofitHelper, private val gsonBuilder : GsonBuilder) : UserDataSource {
    private val BASE_URL = "http://192.168.1.106:3000"

    override fun authenticateUser(account_name: String, email: String, password: String, callback: UserDataSource.AuthenticateUserCallback) {

        val gson : Gson = gsonBuilder.registerTypeAdapter(User::class.java, UserDeserializer()).create()

        val userService : Call<User> = retrofitHelper.createService(BASE_URL, null, UserService::class.java, GsonConverterFactory.create(gson))
                .authenticateUser(account_name, email, password)

        userService.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    callback.onAuthenticated(response.body()!!)
                }else{
                    callback.onFailed(response.code().toString() + " -> " + response.errorBody()?.string(), response.code())
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                callback.onFailed(t?.message ?: "Network connection error" , 0)
            }
        })

    }
}