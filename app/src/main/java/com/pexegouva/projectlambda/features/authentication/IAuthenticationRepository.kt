package com.pexegouva.projectlambda.features.authentication

import arrow.core.Either
import arrow.core.Right
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.login.LoginFailures

interface IAuthenticationRepository {
  fun login(email: String, password: String): Either<Failure, AccessToken>
  fun logout(): Either<Failure, Boolean>
  fun storeToken(accessToken: AccessToken): Either<Failure, Boolean>
  fun getAccessToken(): Either<Failure, AccessToken>

  class Network(
    private val service: AuthenticationService
  ) :
    IAuthenticationRepository {
    override fun login(email: String, password: String): Either<Failure, AccessToken> =
      service.login(email, password).fold(
        { Either.left(LoginFailures.IncorrectEmailOrPassword()) },
        { Either.right(it.toAccessToken()) }
      )

    override fun logout(): Either<Failure, Boolean> =
      Right(true)

    override fun storeToken(accessToken: AccessToken): Either<Failure, Boolean> {
      TODO("Not yet implemented")
    }

    override fun getAccessToken(): Either<Failure, AccessToken> {
      TODO("Not yet implemented")
    }
  }

  class Database(
    private val authenticationDao: AuthenticationDao
  ):
    IAuthenticationRepository {
    override fun login(email: String, password: String): Either<Failure, AccessToken> {
      TODO("Not yet implemented")
    }

    override fun logout(): Either<Failure, Boolean> =
      authenticationDao.deleteSessionToken().fold(
        { Either.left(Failure.DbFailure()) },
        { Either.right(true) }
      )

    override fun storeToken(accessToken: AccessToken): Either<Failure, Boolean> =
      authenticationDao.storeSessionToken(accessToken.toAccessTokenEntity()).fold(
        { Either.left(Failure.DbFailure()) },
        { Either.right(true) }
      )

    override fun getAccessToken(): Either<Failure, AccessToken> =
      authenticationDao.findSessionToken().fold(
        { Either.left(Failure.DbFailure()) },
        { Either.right(it.toAccessToken()) }
      )
  }
}
