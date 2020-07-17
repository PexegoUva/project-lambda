package com.pexegouva.projectlambda.features.authentication

import arrow.core.Try
import com.pexegouva.projectlambda.features.authentication.AccessTokenEntity
import com.pexegouva.projectlambda.features.authentication.AuthenticationApi

class AuthenticationService {
  private val loginApi by lazy { AuthenticationApi() }

  fun login(email: String, password: String): Try<AccessTokenEntity> =
    Try { loginApi.login(email, password) }
}
