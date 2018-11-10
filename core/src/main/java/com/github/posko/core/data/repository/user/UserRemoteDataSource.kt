package com.github.posko.core.data.repository.user

import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.extension.toUser
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Failure
import retrofit2.HttpException
import java.lang.IllegalStateException

class UserRemoteDataSource(private val services : PoskoServices) : UserGateway{
    override suspend fun saveUser(user: User) {
        throw IllegalStateException ("Should never be called")
    }

    override suspend fun login(domain : String, account_name: String, email: String, password: String): Either<Failure, User> {
        return try {
            val result = services.login(domain, account_name, email, password).await()
            Either.Right(result.toUser())
        } catch (e : HttpException) {
            Either.Left(Failure.HttpFailure(e.code(), e.message()))
        } catch (e : Throwable) {
            Either.Left(Failure.TransactionFailure(if(e.localizedMessage != null) e.localizedMessage!! else "Something went wrong!"))
        }
    }
}