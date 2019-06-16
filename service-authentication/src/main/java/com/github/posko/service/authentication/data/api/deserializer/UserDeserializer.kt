package com.github.posko.service.authentication.data.api.deserializer

import com.github.posko.service.authentication.data.api.model.UserRaw
import com.google.gson.*
import java.lang.reflect.Type

class UserDeserializer : JsonDeserializer<UserRaw> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): UserRaw {
        val outer: JsonObject = json.asJsonObject

        val user = outer.getAsJsonObject("user")

        return Gson().fromJson(user, UserRaw::class.java)
    }
}