package com.github.posko.pos.gateways.user

import com.github.posko.core.data.api.deserializer.UserDeserializer
import com.github.posko.core.data.api.model.UserRaw
import com.github.posko.core.data.extension.toUser
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure
import com.google.gson.GsonBuilder
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class FakeUserRemoteDataSource : UserGateway {

    private val userRaw = "{\n" +
            "    \"user\": {\n" +
            "        \"id\": 1,\n" +
            "        \"email\": \"admin@first_company.com\",\n" +
            "        \"first_name\": \"Juan\",\n" +
            "        \"last_name\": \"Dela Cruz\",\n" +
            "        \"token\": \"5at99PaLihcTdLeXu55bH6ZY\",\n" +
            "        \"auth_token\": \"PzJ5HCshnEwHPNTLq3vg1dQm\",\n" +
            "        \"created_at\": \"2018-10-27T17:49:04.089Z\"\n" +
            "    }\n" +
            "}";

    override suspend fun login(account_name: String, email: String, password: String): Either<Failure, User> {
        launch {
            delay(5000)
        }

        val gson = GsonBuilder().setPrettyPrinting().registerTypeAdapter(UserRaw::class.java, UserDeserializer()).create()
        return Either.Right(gson.fromJson(userRaw, UserRaw::class.java).toUser())

    }

}