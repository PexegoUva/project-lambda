package com.pexegouva.projectlambda.features.login

import arrow.core.Either
import com.pexegouva.projectlambda.base.error.Failure

interface ILoginRepository {
  fun login(email: String, password: String): Either<Failure, AccessToken>
}
