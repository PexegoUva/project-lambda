package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.authentication.AccessToken
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository

class StoreSessionToken(
  private val authenticationRepository: AuthenticationRepository
) {
  fun execute(accessToken: AccessToken): Either<Failure, Boolean> {
    return authenticationRepository.storeToken(accessToken)
  }
}
