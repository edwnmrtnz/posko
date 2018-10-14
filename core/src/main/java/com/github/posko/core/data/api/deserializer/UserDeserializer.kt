package com.github.posko.core.data.api.deserializer

import com.github.posko.core.data.api.model.UserRaw
import com.google.gson.*
import java.lang.reflect.Type

class UserDeserializer : JsonDeserializer<UserRaw> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): UserRaw {
        val jsonObject : JsonObject = json!!.asJsonObject

        val userJsonObject = jsonObject.getAsJsonObject("user")

        return Gson().fromJson(userJsonObject, UserRaw::class.java)
    }
}