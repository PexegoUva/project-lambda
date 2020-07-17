package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.authentication.AccessToken
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository

class PostLogin(
  private val authenticationRepository: AuthenticationRepository
) {
  fun execute(email: String, password: String): Either<Failure, AccessToken> {
    return authenticationRepository.login(email, password)
  }
}
