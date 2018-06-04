package com.github.edwnmrtnz.posko.injection

import android.content.Context
import com.github.edwnmrtnz.posko.data.database.PoskoDatabase
import com.github.edwnmrtnz.posko.data.repository.user.UserLocalDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRemoteDataSource
import com.github.edwnmrtnz.posko.data.repository.user.UserRepository
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper
import com.github.edwnmrtnz.posko.helper.SessionHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Injection {
    companion object {

        @JvmStatic fun provideRetrofitHelper() : RetrofitHelper {
            return RetrofitHelper()
        }

        @JvmStatic fun provideUserLocalDataSource(context : Context) : UserLocalDataSource{
            return UserLocalDataSource(PoskoDatabase.getInstance(context.applicationContext).userDao())
        }

        @JvmStatic fun provideUserRemoteDataSource(retrofitHelper: RetrofitHelper, gson: GsonBuilder) : UserRemoteDataSource {
            return UserRemoteDataSource(retrofitHelper, gson)
        }

        @JvmStatic fun provideUserRepository(userLocalDataSource: UserLocalDataSource, userRemoteDataSource: UserRemoteDataSource) : UserRepository {
            return UserRepository.getInstance(userLocalDataSource, userRemoteDataSource)
        }

        @JvmStatic fun provideSessionHelper(context: Context) : SessionHelper{
            val userRepository : UserRepository = provideUserRepository(provideUserLocalDataSource(context), provideUserRemoteDataSource(provideRetrofitHelper(), GsonBuilder().setPrettyPrinting()));
            return SessionHelper(userRepository)
        }
    }

}