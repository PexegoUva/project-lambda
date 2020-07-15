package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

class PostLogin
  constructor(private val loginRepository: LoginRepository){

  fun execute(email: String, password: String): Either<Failure, AccessToken> {
    return loginRepository.login(email, password)
  }
}
