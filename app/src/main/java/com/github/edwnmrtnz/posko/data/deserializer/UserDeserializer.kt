package com.github.edwnmrtnz.posko.data.deserializer

import com.github.edwnmrtnz.posko.data.model.User
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class UserDeserializer : JsonDeserializer<User> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): User {
        val jsonObject : JsonObject = json!!.asJsonObject

        val userJsonObject = jsonObject.getAsJsonObject("user")

        return User(userJsonObject.get("email").asString,
                userJsonObject.get("first_name").asString,
                userJsonObject.get("last_name").asString,
                userJsonObject.get("token").asString,
                userJsonObject.get("auth_token").asString,
                userJsonObject.get("created_at").asString)
    }
}