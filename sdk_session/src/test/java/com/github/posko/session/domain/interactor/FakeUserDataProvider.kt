package com.github.posko.session.domain.interactor

import com.github.posko.session.data.api.deserializer.UserDeserializer
import com.github.posko.session.data.api.model.UserRaw
import com.github.posko.session.data.extension.toDomain
import com.github.posko.session.domain.model.User
import com.github.posko.sharedtest.fakes.SessionFakeData
import com.google.gson.GsonBuilder

class FakeUserDataProvider {
    companion object {
        fun provideUser() : User{
            return GsonBuilder().registerTypeAdapter(
                    UserRaw::class.java, UserDeserializer()
            ).create().fromJson(SessionFakeData.getUser(), UserRaw::class.java).toDomain()
        }
    }
}