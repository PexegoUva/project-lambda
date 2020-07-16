package com.pexegouva.projectlambda.features.login

import com.pexegouva.projectlambda.base.extension.isEqual

class LoginApi: ILoginApi {
  companion object {
    private const val EXISTING_USER_EMAIL = "pexegouva@leviathan.com"
    private const val EXISTING_USER_PASSWORD = "chupliflascinoso"
  }

  @Throws(LoginEndpointException.IncorrectEmailOrPasswordException::class)
  override fun login(email: String, password: String): AccessTokenEntity =
    when (email.isEqual(EXISTING_USER_EMAIL) && password.isEqual(EXISTING_USER_PASSWORD)) {
      true -> AccessTokenEntity(token = java.util.UUID.randomUUID().toString())
      else -> throw LoginEndpointException.IncorrectEmailOrPasswordException()
    }
}
