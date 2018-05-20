package com.github.edwnmrtnz.poskocore.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type


data class User(@SerializedName("email") val email : String,
                @SerializedName("first_name") val firstName: String,
                @SerializedName("last_name") val lastName : String,
                @SerializedName("token") val token : String,
                @SerializedName("auth_token") val authToken : String,
                @SerializedName("created_at") val created_at : String)