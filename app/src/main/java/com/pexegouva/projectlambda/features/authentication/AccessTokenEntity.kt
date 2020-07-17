package com.pexegouva.projectlambda.features.authentication

data class AccessTokenEntity(
  val token: String
) {
  fun toAccessToken() =
    AccessToken(token)
}
