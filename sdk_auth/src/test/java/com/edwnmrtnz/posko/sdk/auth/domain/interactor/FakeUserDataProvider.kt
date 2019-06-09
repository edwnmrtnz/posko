package com.github.posko.authentication.domain.interactor

import com.edwnmrtnz.posko.sdk.auth.data.api.deserializer.UserDeserializer
import com.edwnmrtnz.posko.sdk.auth.data.api.model.UserRaw
import com.edwnmrtnz.posko.sdk.auth.domain.model.User
import com.github.posko.sharedtest.fakes.SessionFakeData
import com.google.gson.GsonBuilder

class FakeUserDataProvider {
    companion object {
        fun provideUser() : User {
            return GsonBuilder().registerTypeAdapter(
                    UserRaw::class.java, UserDeserializer()
            ).create().fromJson(SessionFakeData.getUser(), UserRaw::class.java).toDomain()
        }
    }
}