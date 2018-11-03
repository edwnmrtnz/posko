package com.github.posko.core.data.repository.user

import com.github.posko.core.data.api.services.PoskoServices
import com.github.posko.core.data.extension.toUser
import com.github.posko.core.domain.gateways.UserGateway
import com.github.posko.core.domain.model.User
import com.github.posko.core.domain.result.Either
import com.github.posko.core.domain.result.Error
import retrofit2.HttpException

class UserRemoteDataSource(private val services : PoskoServices) : UserGateway{
    override suspend fun login(account_name: String, email: String, password: String): Either<Error, User> {
        return try {
            val result = services.login(account_name, email, password).await()
            Either.Right(result.toUser())

        } catch (e : HttpException) {
            Either.Left(Error.HttpError(e.code(), e.message()))
        } catch (e : Throwable) {
            Either.Left(Error.TransactionError(if(e.localizedMessage != null) e.localizedMessage!! else "Something went wrong!"))
        }
    }
}