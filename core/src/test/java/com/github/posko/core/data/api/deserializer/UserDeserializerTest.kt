package com.github.posko.core.data.api.deserializer

import com.github.posko.core.AssetReader
import com.github.posko.core.UnitTest
import com.github.posko.core.data.api.model.UserRaw
import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test

class UserDeserializerTest : UnitTest() {

    @Test
    fun `should be able to deserialize user`() {

        val gson = GsonBuilder().setPrettyPrinting().registerTypeAdapter(UserRaw::class.java, UserDeserializer()).create();

        val user = gson.fromJson(readFile("stubs/user_sign_in.txt"), UserRaw::class.java);

        assertNotNull(user)

        assertEquals("admin@first_company.com", user.email)

        doPrint(user)
    }
}