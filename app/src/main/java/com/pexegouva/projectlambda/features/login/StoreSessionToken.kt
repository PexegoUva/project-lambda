package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

class StoreSessionToken(
  private val loginRepository: LoginRepository
) {
  fun execute(accessToken: AccessToken): Either<Failure, Boolean> {
    return loginRepository.storeToken(accessToken)
  }
}
