package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

class LoginRepository: ILoginRepository {
  override fun login(email: String, password: String): Either<Failure, AccessToken> {
    TODO("Not yet implemented")
  }
}
