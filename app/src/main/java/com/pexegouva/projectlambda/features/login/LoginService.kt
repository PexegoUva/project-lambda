package com.pexegouva.projectlambda.features.login

import arrow.core.Try

class LoginService {
  private val loginApi by lazy { LoginApi() }

  fun login(email: String, password: String): Try<AccessTokenEntity> =
    Try { loginApi.login(email, password) }
}
