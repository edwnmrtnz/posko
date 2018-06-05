package com.github.edwnmrtnz.posko.data.deserializer

import com.github.edwnmrtnz.posko.data.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test

class UserDeserializerTest {
    val rawJson : String = "{\n" +
            "    \"user\": {\n" +
            "        \"email\": \"admin@first_company.com\",\n" +
            "        \"first_name\": \"Juan\",\n" +
            "        \"last_name\": \"Dela Cruz\",\n" +
            "        \"token\": \"BrFsicNM3iE1FsQKouWVa3Un\",\n" +
            "        \"auth_token\": \"dNe1XK18UVH4TEVJHBomzfD7\",\n" +
            "        \"created_at\": \"2018-05-20T14:23:55.655Z\"\n" +
            "    }\n" +
            "}"

    @Test
    fun deserializeTest(){
        val gson : Gson = GsonBuilder().registerTypeAdapter(User::class.java, UserDeserializer()).create()

        val user : User = gson.fromJson(rawJson, User::class.java);

        assertNotNull(user)

        assertEquals(user.email, "admin@first_company.com")

        assertEquals(user.firstName, "Juan")

        assertEquals(user.lastName, "Dela Cruz")

    }


}