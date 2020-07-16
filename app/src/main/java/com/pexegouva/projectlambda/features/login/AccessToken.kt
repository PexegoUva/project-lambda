package com.pexegouva.projectlambda.features.login

data class AccessToken(
  val token: String
) {
  fun toAccessTokenEntity() = AccessTokenEntity(token)
}
