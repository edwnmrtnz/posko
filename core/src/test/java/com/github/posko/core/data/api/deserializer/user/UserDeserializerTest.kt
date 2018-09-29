package com.github.posko.core.data.api.deserializer.user

import com.github.posko.core.AssetReader
import com.github.posko.core.data.api.model.UserRaw
import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test

class UserDeserializerTest {

    @Test
    fun deserialize() {

        val gson = GsonBuilder().setPrettyPrinting().registerTypeAdapter(UserRaw::class.java, UserDeserializer()).create();

        val user = gson.fromJson(AssetReader.readJsonFile("/stubs/user_sign_in.txt"), UserRaw::class.java);

        assertNotNull(user)

        System.out.println(gson.toJson(user))
    }
}