package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

interface ILoginRepository {
  fun login(email: String, password: String): Either<Failure, AccessToken>

  class Network
  constructor(private val service: LoginService) : ILoginRepository {
    override fun login(email: String, password: String): Either<Failure, AccessToken> =
      service.login(email, password).fold(
        { Either.left(LoginFailures.IncorrectEmailOrPassword()) },
        { Either.right(it.toAccessToken()) }
      )
  }
}
