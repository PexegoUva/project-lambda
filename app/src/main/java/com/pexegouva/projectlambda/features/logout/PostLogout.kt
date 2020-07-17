package com.pexegouva.projectlambda.features.logout

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure
import com.pexegouva.projectlambda.features.authentication.AuthenticationRepository

class PostLogout(
  private val loginRepository: AuthenticationRepository
) {
  fun execute(): Either<Failure, Boolean> {
    return loginRepository.logout()
  }
}
