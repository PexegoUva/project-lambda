package com.pexegouva.projectlambda.features.login

data class AccessTokenEntity(
  val token: String
) {
  fun toAccessToken() = AccessToken(token)
}
